package puzzle.solver;

import puzzle.state.Direction;
import puzzle.state.PuzzleState;

import java.util.EnumSet;

public class Node {

    private PuzzleState state;
    private EnumSet<Direction> operators;
    private Node parent;
    private Direction direction;

    public Node(PuzzleState state) {
        this.state = state;
        operators = state.getLegalMoves();
    }

    public Node(PuzzleState state, Node parent, Direction direction) {
        this(state);
        this.parent = parent;
        this.direction = direction;
    }

    public PuzzleState getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean hasNextChild() {
        return ! operators.isEmpty();
    }

    public Node nextChild() {
        if (! hasNextChild()) {
            return null;
        }
        var iterator = operators.iterator();
        var direction = iterator.next();
        iterator.remove();
        PuzzleState newState = state.clone();
        newState.move(direction);
        return new Node(newState, this, direction);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }
        return (o instanceof Node n) && state.equals(n.getState());
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public String toString() {
        return parent != null ? String.format("%s %s", direction, state) : state.toString();
    }

}
