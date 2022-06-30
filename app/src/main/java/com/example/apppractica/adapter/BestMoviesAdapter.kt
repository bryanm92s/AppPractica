
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.apppractica.BestMovies
import com.example.apppractica.Movies
import com.example.apppractica.R
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

    val Logo: ImageView = itemView.findViewById(R.id.ivLogo_) as ImageView
    val title: TextView = itemView.findViewById(R.id.tvtitle_) as TextView
    val stars: TextView = itemView.findViewById(R.id.tvstars_) as TextView


    fun render(items: BestMovies) {

      Picasso.get().load(items.logo).into(itemView.ivLogo_)
      stars.text= items.stars.toString()
      title.text = items.title

      /*itemView.ivLogo.setOnClickListener {
          Toast.makeText(itemView.ivLogo.context, items.title, Toast.LENGTH_SHORT).show()
      }*/

      // Gestionar clicks en el cuadro del RecyclerView

      itemView.setOnClickListener {
        Toast.makeText(itemView.ivLogo_.context,items.title, Toast.LENGTH_SHORT).show()

        //val context=itemView.ivLogo.context

        //val intent = Intent(itemView.ivLogo.context, MovieDetail::class.java)

        //intent.putExtra("Title", items.title)
        //intent.putExtra("Cast", items.cast)
        //itemView.context.startActivity(intent);
        //itemView.ivLogo.context.startActivity(intent)
      }
    }
  }
}