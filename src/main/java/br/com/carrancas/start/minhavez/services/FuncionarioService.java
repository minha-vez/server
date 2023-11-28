package br.com.carrancas.start.minhavez.services;

import br.com.carrancas.start.minhavez.dto.request.FuncionarioNewRequestDTO;
import br.com.carrancas.start.minhavez.dto.response.FuncionarioResponseDTO;
import br.com.carrancas.start.minhavez.entities.Empresa;
import br.com.carrancas.start.minhavez.entities.Funcionario;
import br.com.carrancas.start.minhavez.eums.EnumRole;
import br.com.carrancas.start.minhavez.repositories.FuncionarioRepository;
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
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final EmpresaService empresaService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public FuncionarioResponseDTO criar(int empresaId, FuncionarioNewRequestDTO funcionarioNewRequestDTO) {

        String senhaEncriptada = passwordEncoder.encode(funcionarioNewRequestDTO.getPassword());

        User user = User.builder()
                .email(funcionarioNewRequestDTO.getEmail())
                .password(senhaEncriptada)
                .name(funcionarioNewRequestDTO.getNome())
                .build();

        Role roleFuncionario = roleRepository.findByName(EnumRole.ROLE_FUNCIONARIO.name())
                .orElseThrow(() -> new RuntimeException("Role " + EnumRole.ROLE_FUNCIONARIO.name() + " não encontrada"));

        user.setRoles(new HashSet<>(Collections.singletonList(roleFuncionario)));

        usuarioRepository.save(user);

        Funcionario funcionario = FuncionarioNewRequestDTO.toEntity(funcionarioNewRequestDTO);
        Empresa empresa = empresaService.getEmpresa(empresaId);
        funcionario.setEmpresa(empresa);
        funcionarioRepository.save(funcionario);
        return FuncionarioResponseDTO.toDto(funcionario);
    }

    public Funcionario getPessoa(String email) {
        return funcionarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

    }

    public List<FuncionarioResponseDTO> listarPessoa() {
        List<Funcionario> funcionarioList = funcionarioRepository.findAll();
        return funcionarioList.stream()
                .map(pessoa -> FuncionarioResponseDTO.toDto(pessoa))
                .collect(Collectors.toList());
    }

}