
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.BestMovies
import com.example.apppractica.R
import com.example.apppractica.databinding.ItemHorizontalBinding
import com.squareup.picasso.Picasso

class BestMoviesAdapter(private val bestMovieList: List<BestMovies>) : androidx.recyclerview.widget.RecyclerView.Adapter<BestMoviesAdapter.ViewHolder>() {


  /*override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(viewGroup.context)
    val view = inflater.inflate(R.layout.item_horizontal, viewGroup, false)
    return ViewHolder(view)
  }*/


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      ItemHorizontalBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    val item = bestMovieList[position]
    holder.bind(item)

  }

  override fun getItemCount(): Int {
    return bestMovieList.size
  }

  inner class ViewHolder( val binding: ItemHorizontalBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(items: BestMovies) {

      Picasso.get().load(items.logo).into(binding.ivLogo)
      binding.tvstars.text= items.stars.toString()
      binding.tvtitle.text = items.title

      // Gestionar clicks en el cuadro del RecyclerView
      binding.ivLogo.setOnClickListener {
        Toast.makeText(binding.ivLogo.context,items.title, Toast.LENGTH_SHORT).show()
      }
    }
  }
}