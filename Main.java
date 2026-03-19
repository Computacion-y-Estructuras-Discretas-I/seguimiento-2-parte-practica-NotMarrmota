import java.util.*;

/* 
setA.addAll(setB)	A ∪ B	Agrega a setA los elementos de setB que no estén ya presentes
setA.retainAll(setB)	A ∩ B	Elimina de setA todo lo que no esté en setB
setA.removeAll(setB)	A \ B	Elimina de setA todo lo que sí esté en setB
*/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int na = sc.nextInt(), nb = sc.nextInt(), k = sc.nextInt();

        int[] servidorA = new int[na];
        for (int i = 0; i < na; i++) servidorA[i] = sc.nextInt();

        int[] servidorB = new int[nb];
        for (int i = 0; i < nb; i++) servidorB[i] = sc.nextInt();

        int[] baneados = new int[k];
        for (int i = 0; i < k; i++) baneados[i] = sc.nextInt();

        sc.close();

        TreeSet<Integer> activos = jugadoresActivos(servidorA, servidorB, baneados);

        System.out.println(activos.size());
        StringBuilder sb = new StringBuilder();
        for (int id : activos) sb.append(id).append(' ');
        System.out.println(sb.toString().trim());
    }

    public static TreeSet<Integer> jugadoresActivos(int[] servidorA, int[] servidorB, int[] baneados) {

        TreeSet<Integer> JugadoreServidorA = new TreeSet<>();
        for(int id:JugadoreServidorA) JugadoreServidorA.add(id);

        TreeSet<Integer> JugadoreServidorB = new TreeSet<>();
        for(int id:JugadoreServidorB) JugadoreServidorB.add(id);

        TreeSet<Integer> JugadoresBaneados = new TreeSet<>();
        for(int id:JugadoresBaneados) JugadoresBaneados.add(id);

        JugadoreServidorA.retainAll(JugadoreServidorB);
        JugadoreServidorA.retainAll(JugadoresBaneados);

        return JugadoreServidorA;
       
    }
}

/*
5 4 2
3 7 1 9 3
5 7 2 9
7 2
*/