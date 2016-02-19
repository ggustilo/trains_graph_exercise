package src;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.Collections;
import java.util.NoSuchElementException;

public class DepthFirstSearcher implements Iterator<Town> {
	private Set<Town> visited = new HashSet<Town>();
	private Deque<Iterator<Town>> stack = new LinkedList<Iterator<Town>>();
	private Graph graph;
	private Town next;
	private Town target;

	public void dfsIterator(Graph mainGraph, Town origin, Town destination) {
		this.stack.push(mainGraph.getAllNeighboringTowns(origin).iterator());
		this.graph = mainGraph;
		this.next = origin;
		this.target = destination;
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	private void advance() {
		// get the neighboring towns iterator from the top of the stack and set it in progress
		Iterator<Town> currentLevelOfNeighboringTowns = this.stack.peek();
					// System.out.println("These are the neighboring towns: \n");
					// while (currentLevelOfNeighboringTowns.hasNext()) {
					// 	System.out.println(currentLevelOfNeighboringTowns.next().getName());
					// }
		// if we have already visited this town, keep going
		do {
				// except if there are no more towns in our current stack level
				while (!currentLevelOfNeighboringTowns.hasNext()) {
					//in which case, pop off this level
					System.out.println("Popping it off...");
					this.stack.pop();
						// and if there are no more levels
						if (this.stack.isEmpty()) {
							// then just return
							System.out.println("All empty");
							this.next = null;
							return;
						}
					// otherwise, get the next set of neighboring towns, and set them in progress
					currentLevelOfNeighboringTowns = this.stack.peek();
					System.out.println("Still here\n");
				}

				// keep going through the towns in our current level/iterator
				System.out.println("Iterating");
				this.next = currentLevelOfNeighboringTowns.next();

				// if current town is our target, then pop off this level, get next set of neighboring towns, set them
				// also clear the visited array
				if (this.next == this.target) {
					System.out.println("Got Target!");
					this.stack.pop();
					this.visited.removeAll(visited);
					System.out.println("These are visited: " + visited.size());
					currentLevelOfNeighboringTowns = this.stack.peek();
				}
				
				System.out.println("Next up: " + this.next.getName());
		} while (this.visited.contains(this.next));
		// add all the neighboring towns from the next town onto the stack (as an iterator)
				System.out.println("Adding to stack...");
		this.stack.push(this.graph.getAllNeighboringTowns(this.next).iterator());
		System.out.println(this.stack.size());
		System.out.println(this.visited);
	}

	@Override
	public Town next() {
		if (this.next != null) {
			System.out.println("Currently on - " + next + " : " + next.getName());
			try {
				this.visited.add(this.next);
				return this.next;
			}
			finally {
				this.advance();
			}
		}
		else {
			throw new NoSuchElementException();
		}
	}

}
