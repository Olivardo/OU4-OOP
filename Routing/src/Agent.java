import java.util.HashSet;
import java.util.Hashtable;

public class Agent extends Ant{
    private HashSet<Event> detectedEvents;

    Agent(Node node, int maxJump, Event startEvent) {
        super(node, maxJump);
        detectedEvents = new HashSet<>();
        detectedEvents.add(startEvent);
    }

    @Override
    public void move() {

        if((moves < maxJump) && !isDead()) {
            Node n = getRandomNeighbour();
            if(n != null) {

                currentNode = n;
                currentNode.setVisited();
                collectEvents();

                //currentNode.updateRoutingTable(routingTable);
                moves++;
            } else {
                dead = true;
            }
        }
    }

    public void collectEvents() {
        /*
        for (Event e:currentNode.getKnownEvents()) {
            if(!detectedEvents.contains(e)) {
                detectedEvents.add(e);
            }
        }
        */
    }
}
