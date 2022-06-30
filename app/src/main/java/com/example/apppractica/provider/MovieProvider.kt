package com.example.apppractica.provider

import com.example.apppractica.Movies

class MovieProvider {
    companion object{
        val movieList = listOf<Movies>(
            Movies(
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSg70z4AIh6ip3CKveIeBYgLS7pHxSkwiqTkfTGd3onapZUMzr6",
                "El Grinch",
                "2000",
                "Jim Carrey"
            ),

            Movies(
                "https://phantom-marca.unidadeditorial.es/e6f5a41921207c06cf04a96c1de208a8/resize/1320/f/jpg/assets/multimedia/imagenes/2022/05/25/16534679915914.jpg",
                "SpiderMan",
                "2022",
                "Tom Holland"
            ),

            Movies(
                "https://www.elcolombiano.com/binrepository/880x1100/-160c97/1200d627/none/11101/LMRB/encanto-pster-29-9-21_39005126_20211125001429.jpg",
                "Encanto",
                "2021",
                "Disney"
            ),

            Movies(
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQre31EeKplZHc5Mtfur-CgF_2bOq9fiHiFA0nY-mLG5BUellCi",
                "Sonic 2",
                "2022",
                "Jim Carrey"
            ),

            Movies(
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSKSHO-GYFv94VuQyW6B4usXKwArC7NqWUjy856V2ouFrgjLMyo",
                "Morbius",
                "2022",
                "Jared Leto"
            ),
            Movies(
                "https://es.web.img3.acsta.net/pictures/22/01/27/16/40/2914301.jpg",
                "Batman",
                "2022",
                "Robert Pattinson"
            )
        )
    }
}