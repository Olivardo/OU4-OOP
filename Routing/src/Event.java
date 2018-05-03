public class Event {
    private Node eventNode;
    private int id;
    private int timeStep;

    public Event(Node eventNode, int id, int timeStep) {
        this.eventNode = eventNode;
        this.id = id;
        this.timeStep = timeStep;
    }

    public Node getEventNode() {
        return eventNode;
    }

    public int getId() {
        return id;
    }

    public int getTimeStep() {
        return timeStep;
    }

    public void sendMessage() {
        System.out.println(eventNode.getPosition().getX() + "" + eventNode.getPosition().getY() + ", " + timeStep + ", " +id);
    }
}
