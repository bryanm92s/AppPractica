
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.apppractica.BestMovies
import com.example.apppractica.Movies
import com.example.apppractica.R
import com.example.apppractica.databinding.ItemHorizontalBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_horizontal.view.*
import kotlinx.android.synthetic.main.layout_item_view.view.*


class BestMoviesAdapter(private val bestMovieList: List<BestMovies>) : androidx.recyclerview.widget.RecyclerView.Adapter<BestMoviesAdapter.ViewHolder>() {


  override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(viewGroup.context)
    val view = inflater.inflate(R.layout.item_horizontal, viewGroup, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    //val title = titles[position]
    //holder.title.text = title

    val item = bestMovieList[position]
    holder.render(item)

  }

  override fun getItemCount(): Int {
    return bestMovieList.size
  }

  class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(
      itemView) {

    val binding=ItemHorizontalBinding.bind(itemView)

    fun render(items: BestMovies) {

      Picasso.get().load(items.logo).into(binding.ivLogo)
      binding.tvstars.text= items.stars.toString()
      binding.tvtitle.text = items.title


      itemView.setOnClickListener {
        Toast.makeText(itemView.ivLogo_.context,items.title, Toast.LENGTH_SHORT).show()

      }
    }
  }
}