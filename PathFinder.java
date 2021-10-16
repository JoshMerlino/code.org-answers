import org.code.neighborhood.*;

public class PathFinder {

	// Just some direction management stuff
	enum Direction {
		NORTH, EAST, SOUTH, WEST
	}

	// Method to get the direction the painter is facing
	static Direction getDirection(Painter painter) {
		return painter.facingNorth() ? Direction.NORTH
				: painter.facingEast() ? Direction.EAST : painter.facingSouth() ? Direction.SOUTH : Direction.WEST;
	}

	// Get the opposite direction
	static Direction oppositeDirection(Direction direction) {
		if (direction == Direction.NORTH)
			return Direction.SOUTH;
		if (direction == Direction.EAST)
			return Direction.WEST;
		if (direction == Direction.WEST)
			return Direction.EAST;
		return Direction.NORTH;
	}

	public static void main(String[] args) {

		Painter painter = new Painter();

		// Initialize the direction the buhl is facing
		Direction facing = null;

		// Until the loser get the paint
		while (painter.canMove()) {

			// Get the paint
			while (painter.isOnBucket()) {
				painter.takePaint();
			}

			// walk a bitch forward
			painter.move();

			// Get the direction
			facing = getDirection(painter);

			// Paint the floor if he can
			if (painter.hasPaint()) {
				if (!painter.isOnBucket()) {
					painter.paint("white");
				}
			}

			// Count how many times he has turned so far in the current find iteration
			int turnIterations = 0;

			// Turn player in the right direction
			while (!painter.canMove()) {

				// Exit if he done
				if (turnIterations > 3) {
					break;
				}

				// Turn him
				painter.turnLeft();
				turnIterations++;

				// get current direction
				Direction currentDirection = getDirection(painter);

				// Make sure he dont walk back the way he came
				if (facing == oppositeDirection(currentDirection)) {
					painter.turnLeft();
					turnIterations++;
				}

			}

		}

		// Get the direction
		facing = getDirection(painter);

	}
}