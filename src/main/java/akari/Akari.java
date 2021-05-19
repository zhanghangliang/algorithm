package akari; /**
 * Akari represents a single puzzle of the game Akari.
 *
 * @author Lyndon While
 * @version 2021
 */

import java.util.ArrayList;
import java.util.Arrays;

import static akari.Space.BLACK;
import static akari.Space.BULB;
import static akari.Space.EMPTY;
import static akari.Space.FOUR;
import static akari.Space.ONE;
import static akari.Space.THREE;
import static akari.Space.TWO;
import static akari.Space.ZERO;

public class Akari {
    private String filename; // 拼图文件的名称
    private int size;        // 木板是大小x大小
    private Space[][] board; // 木板是各种类型空间的正方形网格

    /**
     * Akari类的对象的构造方法。
     * 用文件名的内容创建和初始化字段。
     * 拼图文件的布局在LMS页面上进行了说明；
     * 您可能会认为布局始终正确。
     *
     * @param filename
     */
    public Akari(String filename) {
        this.filename = filename;
        // 读取文件获取
        ArrayList<String> lines = new FileIO("src/main/resources/" + filename).getLines();
        // 第一行大小
        this.size = Integer.parseInt(lines.get(0));
        // 初始化整个画板
        clear();
        // 第二行空白黑色
        setBoard(lines.get(1).split(" "), BLACK);
        // 第三行黑色0
        setBoard(lines.get(2).split(" "), ZERO);
        // 第四行黑色1
        setBoard(lines.get(3).split(" "), ONE);
        // 第五行黑色2
        setBoard(lines.get(4).split(" "), TWO);
        // 第六行黑色3
        setBoard(lines.get(5).split(" "), THREE);
        // 第七行黑色4
        setBoard(lines.get(6).split(" "), FOUR);
    }

    /**
     * 使用LMS页面中的示例文件。
     */
    public Akari() {
        this("Puzzles/p7-e7.txt");
    }

    /**
     * 返回拼图文件的名称。
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 返回拼图的大小。
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns true iff k is a legal index into the board.
     */
    public boolean isLegal(int k) {
        // TODO 5 不懂这是需要返回什么
        return false;
    }

    /**
     * 如果r和c均为画板的合法参数，则返回true。
     */
    public boolean isLegal(int r, int c) {
        // TODO 6
        return false;
    }

    /**
     * 如果索引合法，则返回r，c处的方块的内容，
     * 或者抛出illegal argument exception.
     */
    public Space getBoard(int r, int c) {
        if (isLegal(r, c)) {
            return board[r][c];
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 返回x的int等效值。
     * 如果x是数字，则返回0-> 0、1-> 1，依此类推;
     * 如果x是大写字母，则返回A-> 10，B-> 11，依此类推;
     * 或者抛出illegal argument exception.
     */
    public static int parseIndex(char x) {
        if (Character.isDigit(x)) {
            return Integer.parseInt(String.valueOf(x));
        } else if (Character.isUpperCase(x)) {
            return (int) x - 'A' + 10;
        }
        throw new IllegalArgumentException();
    }

    /**
     * 如果索引合法，则在r，c处的方块上单击鼠标左键，ow将不执行任何操作。
     * 如果r，c为空，则放置一个灯泡。如果有灯泡，则将其卸下。
     */
    public void leftClick(int r, int c) {
        Space space = getBoard(r, c);
        if (space.equals(EMPTY)) {
            board[r][c] = BULB;
        } else if (space.equals(BULB)) {
            board[r][c] = EMPTY;
        }
    }

    /**
     * 将板上的所有可变方块设置为空。
     */
    public void clear() {
        board = new Space[this.size][this.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    /**
     * 返回在r，c处与正方形相邻的灯泡个数。
     * 如果r，c是非法坐标，则抛出非法参数异常。
     */
    public int numberOfBulbs(int r, int c) {
        // TODO 14
        return -1;
    }

    /**
     * 如果r，c处的正方形被其他地方的灯泡点亮，则返回true。
     * 如果r，c是非法坐标，则抛出非法参数异常。
     */
    public boolean canSeeBulb(int r, int c) {
        // TODO 15
        return false;
    }

    /**
     * 返回对拼图状态的评估，可以是
     * “在r，c处有碰撞灯泡”，
     * “在r，c的未照明的正方形”，
     * “ r，c处的破折号”，或
     * 三个刻度，如LMS页面上所示。
     * r，c必须是具有此类误差的正方形的坐标。
     * 如果板上有多个错误，则可以退回其中任何一个。
     */
    public String isSolution() {
        // TODO 16
        return null;
    }

    /**
     * 根据输入的字符，初始对应位置
     *
     * @param positions
     * @param type
     */
    private void setBoard(String[] positions, Space type) {
        Arrays.stream(positions).forEach(one -> {
            if ("".equals(one)) {
                return;
            }
            String[] split = one.split("");
            // 行
            int row = Integer.parseInt(split[0]);
            for (int i = 1; i < split.length; i++) {
                int column = Integer.parseInt(split[i]);
                board[row][column] = type;
            }
        });
    }
}