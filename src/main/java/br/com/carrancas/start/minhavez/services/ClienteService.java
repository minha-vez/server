package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.client.EnderecoViaCepClient;
import br.com.carrancas.start.minhavez.dto.request.EnderecoRequestDTO;
import br.com.carrancas.start.minhavez.dto.request.ClienteNewRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.ClienteResponseDTO;
import br.com.carrancas.start.minhavez.entities.Endereco;
import br.com.carrancas.start.minhavez.entities.Cliente;
import br.com.carrancas.start.minhavez.exception.CepInvalidoException;
import br.com.carrancas.start.minhavez.repositories.EnderecoRepository;
import br.com.carrancas.start.minhavez.repositories.ClienteRepository;
import br.com.carrancas.start.minhavez.repositories.RoleRepository;
import br.com.carrancas.start.minhavez.repositories.UsuarioRepository;
import br.com.carrancas.start.minhavez.user.Role;
import br.com.carrancas.start.minhavez.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final EnderecoViaCepClient enderecoViaCepClient;
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ClienteResponseDTO criar(ClienteNewRequestDTO clienteNewRequestDTO) {
        // TODO criar um DTO para criar pessoa, e dentro dele pegar os campos password e email, e salvar usuario e pessoa ao mesmo tempo
        EnderecoRequestDTO enderecoRequestDTO = enderecoViaCepClient.buscarViaCep(clienteNewRequestDTO.getCep());
        if (enderecoRequestDTO.getLogradouro() == null || enderecoRequestDTO.getLocalidade() == null) {
            throw new CepInvalidoException();
        }
        String senhaEncriptada = passwordEncoder.encode(clienteNewRequestDTO.getPassword());

        User user = User.builder()
                .email(clienteNewRequestDTO.getEmail())
                .password(senhaEncriptada)
                .name(clienteNewRequestDTO.getNome())
                .build();

        Role roleCliente = roleRepository.findByName("ROLE_CLIENTE")
                .orElseThrow(() -> new RuntimeException("Role ROLE_CLIENTE não encontrada"));

        user.setRoles(new HashSet<>(Collections.singletonList(roleCliente)));

        usuarioRepository.save(user);
        Endereco endereco = EnderecoRequestDTO.toEntity(enderecoRequestDTO);
        endereco.setNumero(clienteNewRequestDTO.getNumero());
        Cliente cliente = ClienteNewRequestDTO.toEntity(clienteNewRequestDTO);
        salvarPessoaEndereco(endereco, cliente);
        return ClienteResponseDTO.toDto(cliente);
    }

    private void salvarPessoaEndereco(Endereco endereco, Cliente cliente) {
        endereco.setCliente(cliente);
        clienteRepository.save(cliente);
        enderecoRepository.save(endereco);
    }

    public Cliente getPessoa(String email) {
        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

    }

    public List<ClienteResponseDTO> listarPessoa() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream()
                .map(pessoa -> ClienteResponseDTO.toDto(pessoa))
                .collect(Collectors.toList());
    }

}