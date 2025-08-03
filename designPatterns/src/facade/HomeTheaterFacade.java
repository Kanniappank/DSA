/**
 * The Facade Design Pattern provides a simplified interface to a complex subsystem.
 * In this example, the {@code HomeTheaterFacade} class acts as a facade for several
 * components of a home theater system: {@code Projector}, {@code Screen}, {@code Lights},
 * and {@code SoundSystem}. Instead of interacting with each subsystem directly,
 * clients use the facade to perform common operations, such as preparing to watch a movie.
 *
 * The facade encapsulates the interactions between the subsystems, making the client code
 * simpler and easier to use. This promotes loose coupling and hides the complexity of the
 * underlying implementation.
 *
 * Usage Example:
 * <pre>
 *     HomeTheaterFacade theater = new HomeTheaterFacade();
 *     theater.watchMovie();
 * </pre>
 *
 * In this code, calling {@code watchMovie()} on the facade will automatically turn on the projector,
 * lower the screen, dim the lights, and start the sound system, demonstrating the convenience
 * and clarity provided by the facade pattern.
 */
package facade;


class Projector {
    void on() {
        System.out.println("Projector ON");
    }
}

class Screen {
    void down() {
        System.out.println("Screen Down");
    }
}

class Lights {
    void dim() {
        System.out.println("Lights Dimmed");
    }
}

class SoundSystem {
    void play() {
        System.out.println("Playing Sound");
    }
}

public class HomeTheaterFacade {

    private Projector projector = new Projector();
    private Screen screen = new Screen();
    private Lights lights = new Lights();
    private SoundSystem soundSystem = new SoundSystem();

    public void watchMovie() {
        System.out.println("Preparing to watch movie");
        projector.on();
        screen.down();
        lights.dim();
        soundSystem.play();
    }

}

class FacadeDemo {
    public static void main(String[] args) {
        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie();
    }
}
