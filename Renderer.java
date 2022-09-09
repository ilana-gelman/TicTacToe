/**
 * the interface of general renderer.
 */
public interface Renderer{
    /**
     * interface of the renderer
     * all the classes that implements this interface implements rendererBoard function that prints the board if its needed
     * @param board the current board
     */
    void renderBoard(Board board);

}