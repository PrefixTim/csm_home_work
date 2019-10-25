import java.awt.EventQueue
import javax.swing.JFrame

class SwingTimerEx : JFrame() {
    init {

        initUI()
    }

    private fun initUI() {

        add(Board())

        isResizable = false
        pack()

        title = "Star"
        setLocationRelativeTo(null)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }

    internal external fun ssf(s: Int)

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            EventQueue.invokeLater {
                val ex = SwingTimerEx()
                ex.isVisible = true
            }
        }
    }
}