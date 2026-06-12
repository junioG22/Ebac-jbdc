public class Main {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarioDAO.inserirUsuario(
                "Carlos",
                "carlos@gmail.com"
        );

        usuarioDAO.inserirUsuario(
                "Ana",
                "ana@gmail.com"
        );

        usuarioDAO.inserirUsuario(
                "Pedro",
                "pedro@gmail.com"
        );

        System.out.println("\n=== USUÁRIOS CADASTRADOS ===");

        usuarioDAO.listarUsuarios();

        usuarioDAO.atualizarEmail(
                "Ana",
                "novoemailana@gmail.com"
        );

        System.out.println("\n=== APÓS ATUALIZAÇÃO ===");

        usuarioDAO.listarUsuarios();

        usuarioDAO.deletarUsuario("Pedro");

        System.out.println("\n=== APÓS DELETE ===");

        usuarioDAO.listarUsuarios();
    }
}