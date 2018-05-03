import java.util.Stack;

public class Request extends Ant {
    private boolean foundEvent;
    private Stack<Node> traveledpath;

    Request(Node node, int maxJump) {
        super(node, maxJump);

        foundEvent = false;

        traveledpath = new Stack<>();
        traveledpath.push(currentNode);
    }

    public void move() {
        if((moves < maxJump) && !isDead()) {
            Node n = getRandomNeighbour();

            if(n != null) {
                currentNode = n;
                currentNode.setVisited();
               if (false) { //Contains searched event
                    n.sendRespond(traveledpath);
                    this.dead = true;
                } else {
                    traveledpath.push(currentNode);
                }
                moves++;
           }
        }
    }

    public void followPath() {

    }
}
