public class Main_Robot {
    public static void main(String[] args) {

        Robot robot = new Robot(Direction.UP, 0, 0);
        Robot.moveRobot(robot, 5, 7);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
        System.out.println(robot.getDirection());
    }

    public static class Robot {

        private Direction direction;
        private int X;
        private int Y;


        public Robot(Direction direction, int X, int Y) {
            this.direction = direction;
            this.X = X;
            this.Y = Y;
        }


        public Direction getDirection() {
            return direction;
        }

        public int getX() {
            return this.X;
        }

        public int getY() {
            return this.Y;
        }

        public void turnLeft() {
            if (this.direction == Direction.UP) {
                this.direction = Direction.LEFT;
            }
            if (this.direction == Direction.RIGHT) {
                this.direction = Direction.UP;
            }
            if (this.direction == Direction.DOWN) {
                this.direction = Direction.RIGHT;
            }
            if (this.direction == Direction.LEFT) {
                this.direction = Direction.DOWN;
            }
        }

        public void turnRight() {
            if (this.direction == Direction.UP) {
                this.direction = Direction.RIGHT;
            } else if (this.direction == Direction.RIGHT) {
                this.direction = Direction.DOWN;
            } else if (this.direction == Direction.DOWN) {
                this.direction = Direction.LEFT;
            } else if (this.direction == Direction.LEFT) {
                this.direction = Direction.UP;
            }
        }

        public void stepForward() {
            if (this.direction == Direction.UP) {
                Y++;
            } else if (this.direction == Direction.DOWN) {
                Y--;
            } else if (this.direction == Direction.LEFT) {
                X--;
            } else if (this.direction == Direction.RIGHT) {
                X++;
            }
        }

        public static void moveRobot(Robot robot, int toX, int toY) {
            if (robot.getY() != toY) {
                while (robot.getDirection() != ((robot.getY() < toY) ? Direction.UP : Direction.DOWN)) {
                    robot.turnLeft();
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
            if (robot.getX() != toX) {
                while (robot.getDirection() != ((robot.getX() < toX) ? Direction.RIGHT : Direction.LEFT)) {
                    robot.turnLeft();
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }
        }

    }
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

