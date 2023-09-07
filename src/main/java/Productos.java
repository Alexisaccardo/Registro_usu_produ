public class Productos {

        public String Id_Producto;
        public String Nombre;
        public String Tipo;
        public String Cantidad;
        public String valor;

        public Productos(String id_Producto, String nombre, String tipo, String cantidad, String valor) {
            Id_Producto = id_Producto;
            Nombre = nombre;
            Tipo = tipo;
            Cantidad = cantidad;
            this.valor = valor;
        }

        public String getId_Producto() {
            return Id_Producto;
        }

        public void setId_Producto(String id_Producto) {
            Id_Producto = id_Producto;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String nombre) {
            Nombre = nombre;
        }

        public String getTipo() {
            return Tipo;
        }

        public void setTipo(String tipo) {
            Tipo = tipo;
        }

        public String getCantidad() {
            return Cantidad;
        }

        public void setCantidad(String cantidad) {
            Cantidad = cantidad;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }
    }

