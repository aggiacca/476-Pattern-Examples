package Mediator

import java.awt.Font
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

//Colleague interface
internal interface Command {
    fun execute()
}

//Abstract Mediator
interface Mediator {
    fun book()
    fun view()
    fun search()
    fun registerView(v: BtnView)
    fun registerSearch(s: BtnSearch)
    fun registerBook(b: BtnBook)
    fun registerDisplay(d: LblDisplay)
}

//Concrete mediator
class ParticipantMediator : Mediator {

    var btnView: BtnView? = null
    var btnSearch: BtnSearch? = null
    var btnBook: BtnBook? = null
    var show: LblDisplay? = null

    //....
    override fun registerView(v: BtnView) {
        btnView = v
    }

    override fun registerSearch(s: BtnSearch) {
        btnSearch = s
    }

    override fun registerBook(b: BtnBook) {
        btnBook = b
    }

    override fun registerDisplay(d: LblDisplay) {
        show = d
    }

    override fun book() {
        btnBook?.setEnabled(false)
        btnView?.setEnabled(true)
        btnSearch?.setEnabled(true)
        show?.setText("booking...")
    }

    override fun view() {
        btnView?.setEnabled(false)
        btnSearch?.setEnabled(true)
        btnBook?.setEnabled(true)
        show?.setText("viewing...")
    }

    override fun search() {
        btnSearch?.setEnabled(false)
        btnView?.setEnabled(true)
        btnBook?.setEnabled(true)
        show?.setText("searching...")
    }

}

//A concrete colleague
class BtnView(al: ActionListener, var med: Mediator) : JButton("View"), Command {

    init {
        addActionListener(al)
        med.registerView(this)
    }

    override fun execute() {
        med.view()
    }

}

//A concrete colleague
class BtnSearch(al: ActionListener, var med: Mediator) : JButton("Search"), Command {

    init {
        addActionListener(al)
        med.registerSearch(this)
    }

    override fun execute() {
        med.search()
    }

}

//A concrete colleague
class BtnBook(al: ActionListener, var med: Mediator) : JButton("Book"), Command {

    init {
        addActionListener(al)
        med.registerBook(this)
    }

    override fun execute() {
        med.book()
    }

}

class LblDisplay(var med: Mediator) : JLabel("Just start...") {

    init {
        med.registerDisplay(this)
        setFont(Font("Arial", Font.BOLD, 24))
    }

}

class MediatorDemo : JFrame(), ActionListener {

    var med: Mediator = ParticipantMediator()

    init {
        val p = JPanel()
        p.add(BtnView(this, med))
        p.add(BtnBook(this, med))
        p.add(BtnSearch(this, med))
        getContentPane().add(LblDisplay(med), "North")
        getContentPane().add(p, "South")
        setSize(400, 200)
        setVisible(true)
    }

    override fun actionPerformed(ae: ActionEvent) {
        val comd = ae.getSource() as Command
        comd.execute()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            MediatorDemo()
        }
    }

}