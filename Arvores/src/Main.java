import Arvore.Arvore;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL tree = new ArvoreAVL();

        tree.insert(21, tree.getRaiz());
        tree.printaArvore(tree.getRaiz());
    }
} 