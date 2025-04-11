// Interfaz de componente
interface Bebida {
    String getDescripcion();
    double getPrecio();
}

// Componente concreto base
class Espresso implements Bebida {
    @Override
    public String getDescripcion() {
        return "Espresso";
    }
    
    @Override
    public double getPrecio() {
        return 2.0;
    }
}

class Americano implements Bebida {
    @Override
    public String getDescripcion() {
        return "Americano";
    }
    
    @Override
    public double getPrecio() {
        return 1.5;
    }
}

// Clase decoradora base
abstract class DecoradorBebida implements Bebida {
    protected Bebida bebidaDecorada;
    
    public DecoradorBebida(Bebida bebida) {
        this.bebidaDecorada = bebida;
    }
    
    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion();
    }
    
    @Override
    public double getPrecio() {
        return bebidaDecorada.getPrecio();
    }
}

// Decoradores concretos
class DecoradorLeche extends DecoradorBebida {
    public DecoradorLeche(Bebida bebida) {
        super(bebida);
    }
    
    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion() + " + Leche";
    }
    
    @Override
    public double getPrecio() {
        return bebidaDecorada.getPrecio() + 0.5;
    }
}

class DecoradorChocolate extends DecoradorBebida {
    public DecoradorChocolate(Bebida bebida) {
        super(bebida);
    }
    
    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion() + " + Chocolate";
    }
    
    @Override
    public double getPrecio() {
        return bebidaDecorada.getPrecio() + 0.7;
    }
}

class DecoradorCanela extends DecoradorBebida {
    public DecoradorCanela(Bebida bebida) {
        super(bebida);
    }
    
    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion() + " + Canela";
    }
    
    @Override
    public double getPrecio() {
        return bebidaDecorada.getPrecio() + 0.3;
    }
}

// Cliente
public class SistemaCafe {
    public static void main(String[] args) {
        // Creamos un espresso básico
        Bebida miCafe = new Espresso();
        System.out.println("Pedido: " + miCafe.getDescripcion() + " - Precio: $" + miCafe.getPrecio());
        
        // Añadimos leche
        miCafe = new DecoradorLeche(miCafe);
        System.out.println("Pedido: " + miCafe.getDescripcion() + " - Precio: $" + miCafe.getPrecio());
        
        // Añadimos canela
        miCafe = new DecoradorCanela(miCafe);
        System.out.println("Pedido: " + miCafe.getDescripcion() + " - Precio: $" + miCafe.getPrecio());
        
        // Creamos otro pedido: Americano con chocolate y canela
        Bebida otroCafe = new Americano();
        otroCafe = new DecoradorChocolate(otroCafe);
        otroCafe = new DecoradorCanela(otroCafe);
        System.out.println("\nPedido: " + otroCafe.getDescripcion() + " - Precio: $" + otroCafe.getPrecio());
    }
}
