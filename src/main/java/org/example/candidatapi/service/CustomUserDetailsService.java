package org.example.candidatapi.service;

import org.example.candidatapi.dto.UtilisateurDto;
import org.example.candidatapi.entity.Utilisateur;
import org.example.candidatapi.repository.UtilisateurRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByEmail(email);


        if (utilisateur == null ) {
            throw new UsernameNotFoundException("Utilisateur non trouver");
        }

        return new org.springframework.security.core.userdetails.User(
            utilisateur.getEmail(),
            utilisateur.getMotDePasse(),
            List.of(new SimpleGrantedAuthority("ROLE_" + utilisateur.getTypeUtilisateur().name()))
        );
    }
}
