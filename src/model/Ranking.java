package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ranking {
    private List<Usuario> usuarios;


    public Ranking(){
        this.usuarios = new ArrayList<Usuario>();
    }


    public void adicionarUsuario(Usuario usuario) {
        if (!usuarios.contains(usuario)) { // Evita duplicatas
            usuarios.add(usuario);
            ordenarUsuarios();
        } else {
            for (Usuario u : usuarios) {
                if (u.getNome().equals(usuario.getNome())) {
                    u.setPontuacao(usuario.getPontuacao()); // Atualiza pontuação do usuário existente
                }
            }
            ordenarUsuarios();
        }
    }


    //ordenando o ranking com base na pontuação
    private void ordenarUsuarios() {
        usuarios.sort(Comparator.comparingInt(Usuario::getPontuacao).reversed());
    }

    public List<Usuario> getUsuarios() {
        return usuarios.stream()
                .sorted(Comparator.comparingInt(Usuario::getPontuacao).reversed())
                .collect(Collectors.toList());
    }

}
