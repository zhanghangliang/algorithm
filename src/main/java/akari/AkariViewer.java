package akari; /**
 * AkariViewer represents an interface for a player of Akari.
 *
 * @author Lyndon While
 * @version 2021
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AkariViewer implements MouseListener {
    private Akari puzzle;    // 拼图的内部表示
    private SimpleCanvas sc; // 显示窗口

    /**
     * 类AkariViewer的对象的构造方法。
     * 设置所有字段并显示初始拼图。
     */
    public AkariViewer(Akari puzzle) {
        this.puzzle = puzzle;
        // TODO 10
    }

    /**
     * 从文件夹拼图中提供的文件中选择。
     * 数字xyz选择pxy-ez.txt。
     */
    public AkariViewer(int n) {
        this(new Akari("Puzzles/p" + n / 10 + "-e" + n % 10 + ".txt"));
    }

    /**
     * 使用LMS页面上提供的示例文件。
     */
    public AkariViewer() {
        this(77);
    }

    /**
     * 返回拼图的内部状态。
     */
    public Akari getPuzzle() {
        return puzzle;
    }

    /**
     * 返回画布。
     */
    public SimpleCanvas getCanvas() {
        return sc;
    }

    /**
     * 显示最初的难题；有关建议的布局，请参见LMS页面。
     */
    private void displayPuzzle() {
    }

    /**
     * Performs a left click on the square at r,c if the indices are legal, o/w does nothing.
     * Updates both puzzle and the display.
     */
    public void leftClick(int r, int c) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
