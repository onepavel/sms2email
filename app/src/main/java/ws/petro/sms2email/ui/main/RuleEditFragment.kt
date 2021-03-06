package ws.petro.sms2email.ui.main

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ws.petro.sms2email.R
import ws.petro.sms2email.filter.Rule


class RuleEditFragment(rule: Rule?) : Fragment() {

    val rule : Rule? = rule

    companion object {
        fun newInstance() = RuleEditFragment(null)
    }

    private val viewModel: RuleViewModel by activityViewModels()

    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = inflater.inflate(R.layout.fragment_rule_edit, container, false)

        if (rule != null) {
            layout.findViewById<TextView>(R.id.editor_title).setText(R.string.editor_edit)
            layout.findViewById<EditText>(R.id.edit_title).setText(rule.title)
        } else {
            layout.findViewById<TextView>(R.id.editor_title).setText(R.string.editor_new)
        }

        val users = arrayOf(
            "Sim: 1",
            "Sim: 2",
            "Sim: Any",
        )
        val spin = layout.findViewById(R.id.edit_sim) as Spinner
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, 0, users)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter

        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
