/**
 * the factory the renderer object, manages the chosen renderer
 */
public class RendererFactory {
    /**
     * this function chooses the right renderer according the command line input and returns an interface of it
     * @param rendererType  string from the command line with the chosen type of the renderer
     * @return Renderer interface
     */
    Renderer buildRenderer(String rendererType){
        switch (rendererType){
            case "console":
                return new ConsoleRenderer();
            case "none":
                return new VoidRenderer();
            default:
                return null;

        }

    }
}
