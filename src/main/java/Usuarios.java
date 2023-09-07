public class Usuarios {
    public String nombreusuario;
    public String documento;
    public String usuario;
    public String pass;
    public String tipo;

    public Usuarios(String nombreusuario, String documento, String usuario, String pass, String tipo) {
        this.nombreusuario = nombreusuario;
        this.documento = documento;
        this.usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
