import java.util.*;

public class Super2 {
    // Autora: Sonia Duque Paz

    public static void main(String[] args) {
        //param: Esto es el diccionario del supermercado.
        Map<String, Double> precioProducto = new HashMap<>();
        precioProducto.put("avena", 2.21);
        precioProducto.put("garbanzos", 2.39);
        precioProducto.put("tomate", 1.59);
        precioProducto.put("jengibre", 3.13);
        precioProducto.put("quinoa", 4.50);
        precioProducto.put("guisantes", 1.60);

        //param: Mapa del super acumulando la cantidad de cada producto comprado
        Map<String, Integer> compraMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        String input;

        //param: Titulo que vera el usuario.
        //param: Alias el ticket del super
        System.out.println("Bienvenido/a al Supermercado Organico!");
        System.out.println("Productos disponibles: " + precioProducto.keySet());
        System.out.println("Escribe el nombre del producto y la cantidad, o 'fin' para finalizar:");

        while (true) {
            System.out.print("Producto: ");
            input = sc.nextLine().trim().toLowerCase();

            if (input.equals("fin")) {
                break;
            }

            if (!precioProducto.containsKey(input)) {
                System.out.println("Producto no disponible. Intentalo de nuevo.");
                continue;
            }

            System.out.print("Cantidad: ");
            int cantidad;
            try {
                cantidad = Integer.parseInt(sc.nextLine());
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser positiva.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Cantidad Invalida. Por favor introduzca un numero.");
                continue;
            }

            //param: Actualizar cantidad si el producto ya esta en el mapa de compra
            compraMap.put(input, compraMap.getOrDefault(input, 0) + cantidad);
        }

        //param: Preguntar por si el usuario tiene algun descuento
        System.out.print("Introduzca codigo de descuento (INTRO si no tiene ninguno): ");
        String codigoDescuento = sc.nextLine().trim();
        boolean descuentoAplicable = codigoDescuento.equalsIgnoreCase("ECODTO");

        //param: Calcular el total de la cesta
        double total = 0.0;
        System.out.printf("%-15s %-7s %-10s %-10s%n", "Producto", "Precio", "Cantidad", "Subtotal");
        System.out.println("--------------------------------------------");
        for (String producto : compraMap.keySet()) {
            int cant = compraMap.get(producto);
            double precio = precioProducto.get(producto);
            double coste = cant * precio;
            total += coste;
            System.out.printf("%-15s $%-6.2f %-10d $%-9.2f%n", producto, precio, cant, coste);
        }


        //param: Aplicar el descuento si es aplicable.
        System.out.println("--------------------------------------------");
        if (descuentoAplicable) {
            double descuento = total * 0.10;
            total -= descuento;
            System.out.printf("Descuento: $%.2f\n", descuento);
        }
        //param: Esto es el total del ticket del super.
        System.out.println("--------------------------------------------");
        System.out.printf("Total: $%.2f\n", total);
        sc.close();
    }
}
