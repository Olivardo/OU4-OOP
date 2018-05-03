import java.util.Stack;

public class Response extends Ant{
    Stack<Node> pathToTake;

    public Response(Node startNode, int maxJump, Stack<Node> pathToTake) {
        super(startNode,maxJump);
        this.pathToTake = pathToTake;
        System.out.println("Found event, sent response");
    }

    @Override
    public void move() {
        if((moves < maxJump) && !isDead()) {
            currentNode = pathToTake.peek();
            pathToTake.pop();
            if (pathToTake.empty()) {
                System.out.println(currentNode.getPosition().getX() +":" +currentNode.getPosition().getY());
                dead = true;
            }
            moves++;
        }
    }

    public String response() {
        return null;
    }
}
