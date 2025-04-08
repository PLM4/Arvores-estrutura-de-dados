package Arvore;

public class Arvore {
    private NoArvore raiz;

    public Arvore() {
        this.raiz = null;
    }

    public NoArvore getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore raiz) {
        this.raiz = raiz;
    }

    public void insert(int valor) {
        NoArvore novoNo = new NoArvore(valor);

        if (raiz == null) {
            this.raiz = novoNo;
        } else {
            NoArvore atual = this.raiz;
            while (true) {
                if (novoNo.getValor() < atual.getValor()) {
                    if (atual.getEsquerda() != null) {
                        atual = atual.getEsquerda();
                    } else {
                        atual.setEsquerda(novoNo);
                        break;
                    }
                } else {
                    if (atual.getDireita() != null) {
                        atual = atual.getDireita();
                    } else {
                        atual.setDireita(novoNo);
                        break;
                    }
                }
            }
        }
    }

    public NoArvore removerMaior(NoArvore raiz) {
        if (raiz == null) {
            return null;
        }

        if (raiz.getDireita() == null) {
            return raiz.getEsquerda();
        }

        raiz.setDireita(removerMaior(raiz.getDireita()));
        return raiz;
    }

    public NoArvore removerMenor(NoArvore raiz) {
        if (raiz == null) {
            return null;
        }

        if (raiz.getEsquerda() == null) {
            return raiz.getDireita();
        }

        raiz.setEsquerda(removerMenor(raiz.getEsquerda()));
        return raiz;
    }

    public int procuraValor(int valor) {
        return procurarValorRecursico(raiz, valor);
    }

    public int procurarValorRecursico(NoArvore atual, int valor) {
        if (atual == null) {
            return -1;
        }
        if (valor == atual.getValor()) {
            return atual.getValor();
        } else if (valor < atual.getValor()) {
            return procurarValorRecursico(atual.getEsquerda(), valor);
        } else {
            return procurarValorRecursico(atual.getDireita(), valor);
        }
    }

    public void emOrdem(NoArvore atual) {
        if (atual != null) {
            emOrdem(atual.getEsquerda());
            System.out.println(atual.getValor());
            emOrdem(atual.getDireita());
        }
    }

    public void preOrdem(NoArvore atual) {
        if (atual != null) {
            System.out.println(atual.getValor());
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    public void posOrdem(NoArvore atual) {
        if (atual != null) {
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.println(atual.getValor());
        }
    }
}