package puzzle.solver;

import puzzle.state.PuzzleState;

import java.util.HashSet;
import java.util.LinkedList;

public class BreadthFirstSearch {

    public Node search(PuzzleState state) {
        var open = new LinkedList<Node>();
        var seen = new HashSet<Node>();
        var start = new Node(state);
        open.add(start);
        seen.add(start);
        while (! open.isEmpty()) {
            var selected = open.getFirst();
            if (selected.getState().isGoal()) {
                return selected;
            }
            open.removeFirst();
            while (selected.hasNextChild()) {
                Node nextChild = selected.nextChild();
                if (! seen.contains(nextChild)) {
                    open.addLast(nextChild);
                    seen.add(nextChild);
                }
            }
        }
        return null;
    }

    public void printPath(Node node) {
        if (node.getParent() != null) {
            printPath(node.getParent());
        }
        System.out.println(node);
    }

    public static void main(String[] args) {
        var bfs = new BreadthFirstSearch();
        var result = bfs.search(new PuzzleState());
        if (result != null) {
            System.out.println("Solution:");
            bfs.printPath(result);
        } else {
            System.out.println("No solution");
        }
    }

}
