package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ranking {
    private ArrayList<Usuario> usuarios;


    public Ranking(){
        this.usuarios = new ArrayList<Usuario>();
    }

    //adicionando um usuario ao ranking
    public void adicionarUsuario(Usuario usuario){
        ordernarUsuarios();
        usuarios.add(usuario);

    }

    //ordenando o ranking com base na pontuação
    private void ordernarUsuarios(){
        usuarios.sort(new Comparator<Usuario>(){
            @Override
            public int compare(Usuario u1, Usuario u2){
                return u2.getPontuacao() - u1.getPontuacao();
            }
        });
    }
    //usuarios.sort((u1, u2) -> u2.getPontuacao() - u1.getPontuacao());


    public List<Usuario> getUsuarios(){
        return usuarios;
    }
}
