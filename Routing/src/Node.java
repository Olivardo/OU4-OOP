import java.awt.geom.NoninvertibleTransformException;
import java.util.*;


public class Node {
    private Position p;
    private boolean visited;
    private HashSet<Node> neighbours;
    private HashSet<Ant> ants;

    public Node(Position p) {
        this.p = p;

        neighbours = new HashSet<>();
        ants = new HashSet<>();

        visited = false;
    }

    public Position getPosition() {
        return p;
    }

    public HashSet<Node> getNeighbours() {
        return neighbours;
    }

    public void recieveInformation(int id, int timeStep){
        Random r = new Random();

        if(r.nextInt(10000) == 0) {
            if(r.nextBoolean()){

                sendAgent();
            }
            detectEvent(id, timeStep);
        }
    }


    public void removeDeadAnts() {
        Iterator<Ant> antsOnDeathrow = ants.iterator();
        while(antsOnDeathrow.hasNext()) {
            if(antsOnDeathrow.next().isDead()) {
                antsOnDeathrow.remove();
            }
        }
    }

    public void moveAgents() {
        for(Ant ant:ants) {
                ant.move();
        }
    }

    public void recieveResponse() {

    }

    public String waitForResonse() {
       return null;
    }

    public void addNeighbour(Node n) {
        neighbours.add(n);
    }

    private void sendAgent() {
        ants.add(new Agent(this,50, new Event(this, 1,1)));
    }

    public void sendRequest() {
        ants.add(new Request(this,45));
    }

    public void sendRespond(Stack<Node> pathToTravel) {
        ants.add(new Response(this, 45, pathToTravel));
    }

    public void setVisited() {
        this.visited = true;
    }

    public boolean isVisited(){
        return visited;
    }

    public void updateRoutingTable() {

    }

    private void detectEvent(int id, int timeStep) {
        //knownEvents.add(new Event(this, id, timeStep));
    }


}