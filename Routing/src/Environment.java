import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Environment {
    private ArrayList<Node> nodes;
    private int tickCount;

    public Environment(int width, int height, double detectionChance, int maxAgentMoves, int maxRequestMoves) {
        nodes = new ArrayList<>();
        addNodes(width,height);
        setNeighbours();
        tickCount = 0;
    }

    public void tick() {
        for (Node n:nodes) {
            n.recieveInformation(2, tickCount);
            n.moveAgents();
            n.removeDeadAnts();
        }
        if((tickCount%400)==0) {
            not();
        }
        tickCount++;
        System.out.println("Tick: "+tickCount);
    }

    private void addNodes(int width,  int height) {
        for (int x = 0; x<width; x++) {

            for (int y = 0; y < height; y++) {

                nodes.add(new Node(new Position(x*10,y*10)));
            }
        }
    }


    private void setNeighbours(){
        for(Node currentNode: nodes) {

            for(Node neighbour: nodes) {
                if(!currentNode.equals(neighbour)) {
                    int horDis = currentNode.getPosition().getX() - neighbour.getPosition().getX();
                    int verDis = currentNode.getPosition().getY() - neighbour.getPosition().getY();

                    if(Math.abs(verDis) <= 15 && Math.abs(horDis) <= 15) {
                        currentNode.addNeighbour(neighbour);
                    }
                }
            }
        }
    }

    private void not() {
        Random r = new Random();
        for(int i = 0; i < 4; i++) {
            Node n1 = nodes.get(r.nextInt(nodes.size()));
            n1.sendRequest();
        }
    }

    public int getTickCount() {
        return tickCount;
    }
}
