import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public abstract class Ant {
    protected boolean dead;
    protected Node currentNode;

    protected int maxJump;
    protected int moves;

    Ant(Node startNode, int maxJump) {
        this.currentNode = startNode;
        this.maxJump = maxJump;

        moves = 0;
        dead = false;
    }

    public abstract void move();

    protected boolean isDead() {
        return dead;
    }

    protected Node getRandomNeighbour() {
        if(!currentNode.getNeighbours().isEmpty()) {
            Random r = new Random();
            //System.out.println("JYJYJYJY");
            int startIndex = r.nextInt(currentNode.getNeighbours().size());
            for(Node neighbour : currentNode.getNeighbours()) {
                if(!neighbour.isVisited()) {
                    return neighbour;
                }
            }

        }
        return null;
    }
}
