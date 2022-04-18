package com.khaled.debbook.main


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaled.debbook.adapters.*
import com.khaled.debbook.R
import com.khaled.debbook.model.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_holidays.*
import kotlinx.android.synthetic.main.activity_jobs.*
import kotlinx.android.synthetic.main.activity_land_marks.*
import kotlinx.android.synthetic.main.activity_official_documents.*
import kotlinx.android.synthetic.main.activity_phrases.*
import kotlinx.android.synthetic.main.activity_random_info.*
import kotlinx.android.synthetic.main.activity_sports.*
import kotlinx.android.synthetic.main.activity_transport.*
import kotlinx.android.synthetic.main.activity_university.*
import kotlin.random.Random

class PrimaryActivity : AppCompatActivity() {

    lateinit var bannerPrimary: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = getClickedItem()
        MobileAds.initialize(this, getString(R.string.app_id))
        initialize(id)
    }

    private fun getClickedItem(): String? {
        val intent = intent
        val item = intent.getStringExtra("ItemClicked")
        return item
    }

    private fun initialize(id: String?) {
        when (id) {
            "1" ->initializeFoods()
            "2" ->initializeDocuments()
            "3" ->initializeJobs()
            "4" ->initializeLandMarks()
            "5" ->initializeTransport()
            "6" ->initializeSports()
            "7" ->initializeHolidays()
            "8" ->initializeUniversity()
            "9" ->initializePhrases()
            "10" ->initializeRandomInfo()
            "11" ->initializeAskUs()
        }
    }

    private fun addFoods(foods: ArrayList<Food>) {
        foods.add(
            Food(
                "Lángos",
                R.drawable.langos,
                "https://www.google.com/maps/place/Marika+L%C3%A1ngoss%C3%BCt%C5%91/@47.5332559,21.6296745,21z/data=!4m5!3m4!1s0x47470e756a71ce89:0x47f70e69e5b886dc!8m2!3d47.533288!4d21.6297013",
                "This deep fried yeasty dough is the most popular Hungarian street food. Topped with either salty things, such as sour cream, cheese, garlic, bacon, raw onions, or sweets, like fruit jam or chocolate cream. ",
                arrayListOf(
                    "Flour\n" +
                            "Oil \n" +
                            "Yeast\n" +
                            "Sugar and salt\n" +
                            "Toppings of your choice"
                )
            )
        )

        foods.add(
            Food(
                "Gulyás",
                R.drawable.gulyas,
                "https://www.google.com/maps/place/Calico+Jack+Pub/@47.5423898,21.622443,17z/data=!3m1!4b1!4m5!3m4!1s0x47470de4186ab7af:0xeac9fa2bec84daed!8m2!3d47.5423898!4d21.6246317",
                "Often prepared outside, on an open flame, this soup will  surprise you with its diverse flavours. There's many variations to it: some may contain beans and sausages or other kinds of meats. What doesn't change however, is the spiciness of this dish. ",
                arrayListOf(
                    "Pork sausage\n" +
                            "Beef/ Pork/ Chicken meat \n" +
                            "Potatoes\n" +
                            "Beans\n" +
                            "Fresh vegetables and herbs\n" +
                            "Paprika powder, along with other hot spices\n" +
                            "Onions, garlic"
                )
            )
        )
        foods.add(
            Food(
                "Kürtőskalács",
                R.drawable.kurtos,
                "https://www.google.com/maps/place/Kovacs+kalacs/@47.5308391,21.6217037,17z/data=!3m1!4b1!4m5!3m4!1s0x47470f71a011f361:0x48b046363ee39651!8m2!3d47.5308391!4d21.6238924",
                "Also known as chimney cake, this sweet bread originally comes from Transylvania. It’s also a popular winter food, sold on Christmas fares and festivals. The sweet yeasty dough is wrapped on a thick wooden stick, then covered entirely in sugar, after which it is put to rotate above hot, sizzling coals, that cook the dough and melt the sugar, so then it can be rolled into toppings like: walnuts, coconut shreds, hazelnuts, cinnamon, chocolate pieces, etc. Recently people started forming them into cones and filling them with icecream or fruits. They even made a version which is covered in cheese and filled with sausages.",
                arrayListOf(
                    "Flour\n" +
                            "Yeast \n" +
                            "Eggs\n" +
                            "Orange zest\n" +
                            "Sugar\n" +
                            "Vanilla\n" +
                            "Butter\n" +
                            "Topping of your choice"
                )
            )
        )
        foods.add(
            Food(
                "Csirke Paprikás",
                R.drawable.csirkepaprikas,
                "https://www.google.com/maps/place/IKON+Restaurant/@47.5298089,21.6224314,17z/data=!3m1!4b1!4m5!3m4!1s0x47470e0cacdbc04b:0xf7a4bc6aab8fec7!8m2!3d47.5298089!4d21.6246201",
                "Juicy chicken thighs swimming in a creamy, slightly smoky white sauce, with strong hints of red pepper, and paprika powder. Most often paired with mashed potatoes, macaroni or nokedli (a Hungarian, pasta-like side).",
                arrayListOf(
                    "Chicken\n" +
                            "Heavy cream, milk, sour cream \n" +
                            "Red peppers\n" +
                            "Onions, garlic\n" +
                            "Flour\n" +
                            "Spices\n" +
                            "Parsley"
                )
            )
        )
        foods.add(
            Food(
                "Szilvás gombóc",
                R.drawable.szilvas,
                "",
                "These little balls of pure happiness are everyone’s favorite. The dumplings are rolled into a crunchy mixture of breadcrumbs, sugar and vanilla, and once you cut them, a steamy sweet surprise oozes out: juicy hot plums in a sweet, cinnamon sauce. ",
                arrayListOf(
                    "Eggs\n" +
                            "Flour \n" +
                            "Potatoes\n" +
                            "Butter/ Pork fat\n" +
                            "Cinnamon and vanilla\n" +
                            "Plums\n" +
                            "Breadcrumbs\n" +
                            "Sugar"
                )
            )
        )
        foods.add(
            Food(
                "Töltött káposzta",
                R.drawable.kaposzta,
                "https://www.google.com/maps/place/R%C3%A9gi+Posta+%C3%89tterem+Kft./@47.5283542,21.6213905,17z/data=!3m1!4b1!4m5!3m4!1s0x47470e0cd2bbff71:0x5abfb41d9b17d7c3!8m2!3d47.5283542!4d21.6235792",
                "This is the traditional Sunday-afternoon food. Nothing says home, to Hungarians, quite like this dish, paired with Husleves. due to its greasiness and juiciness, people always eat it with tejfol (sourcream), and fresh warm bread.",
                arrayListOf(
                    "Ground pork/ Beef\n" +
                            "Cabbage leaves \n" +
                            "Herbs, onions, garlic"
                )
            )
        )
        foods.add(
            Food(
                "Bejgli",
                R.drawable.bejgli,
                "",
                "Most often sold on Christmas fares, these spirally sweets come in two different flavors: poppy seeds and walnuts. They are a must have for the winter holidays, as small seeds are said to bring good financial luck for the coming year. Cut them up and soak them in sweetened milk, topped with some whipped cream and you have another sweet dish called “Mákosguba”. ",
                arrayListOf(
                    "Eggs\n" +
                            "Flour \n" +
                            "Oil, butter\n" +
                            "Sugar\n" +
                            "Orange zest\n" +
                            "Raisins\n" +
                            "Poppy seeds / Walnuts"
                )
            )
        )
        foods.add(
            Food(
                "Kolbászos bableves",
                R.drawable.kolbaszos,
                "https://www.google.com/maps/place/Malom+%C3%89tterem/@47.534943,21.6101893,17z/data=!3m1!4b1!4m5!3m4!1s0x47470e062f5f1e69:0xf8c4fd116ed90958!8m2!3d47.534943!4d21.612378",
                "A rich and creamy bean soup, spiced up with some original, spicy, smoked Hungarian sausages. You will most probably find this dish on festivals, where they prepare it much like (Gulyás soup), in huge pans over fire. Sour cream, raw red onions and a piece of fresh white bread is a must side with this one!",
                arrayListOf(
                    "White beans\n" +
                            "Hungarian pork sausage\n" +
                            "Szalonna\n" +
                            "Potatoes, peppers\n" +
                            "Onions, garlic\n" +
                            "Spices\n" +
                            "Parsley and other fresh herbs"
                )
            )
        )
        foods.add(
            Food(
                "Madártej",
                R.drawable.madartej,
                "https://www.google.com/maps/place/Sz%C5%91ke+Cukr%C3%A1szda/@47.5349416,21.5948684,14z/data=!4m9!1m2!2m1!1zU3rFkWtlIEN1a3LDoXN6ZGE!3m5!1s0x47470e0b77891e4d:0x99044a75089b9bc6!8m2!3d47.5310986!4d21.6219303!15sChFTesWRa2UgQ3VrcsOhc3pkYSIDiAEBWhMiEXN6xZFrZSBjdWtyw6FzemRhkgEMZGVzc2VydF9zaG9w",
                "At first the idea might sound bizarre, but if you try this desert, you won’t regret it! The name of this sweet literally means “bird’s milk”. Eating it feels like eating actual clouds, as the whites of the eggs are whipped up and then cooked in a vanilla flavored, sweet mixture of egg yolks and milk. The eggs are completely cooked, so they are safe to eat, and all you taste all along is vanilla and clouds of sweetness.",
                arrayListOf(
                    "Eggs\n" +
                            "Milk \n" +
                            "Vanilla\n" +
                            "Sugar"
                )
            )
        )
        foods.add(
            Food(
                "Halászlé",
                R.drawable.halaszle,
                "https://www.google.com/maps/place/Csakhal+Bisztr%C3%B3+(Belv%C3%A1ros)/@47.5325157,21.6087347,17z/data=!3m1!4b1!4m5!3m4!1s0x47470e06072e2edb:0x8c944cecf09c0fba!8m2!3d47.5325157!4d21.6109234",
                "One could say this soup is like a Gulyas, made specifically for those who prefer fish to other types of meats. it has a really unique flavour palette, as it has everything hungarian : spiciness, smokiness and loads of paprika, all this paired with huge fish pieces. What can you say, hungarians know what makes a dish truly  irresistible.",
                arrayListOf(
                    "Fish\n" +
                            "Onions, garlic \n" +
                            "Paprika, tomatoes, potatoes\n" +
                            "Pasta"
                )
            )
        )
        foods.add(
            Food(
                "Dobostorta",
                R.drawable.dobos,
                "https://www.google.com/maps/place/Kismandula+Cukr%C3%A1szda/@47.5313478,21.5911735,13z/data=!4m9!1m2!2m1!1sKismandula+Cukr%C3%A1szda!3m5!1s0x47470f61a1c35dbb:0x7aa4ca2054b02c81!8m2!3d47.530311!4d21.628405!15sChVLaXNtYW5kdWxhIEN1a3LDoXN6ZGEiA4gBAVoXIhVraXNtYW5kdWxhIGN1a3LDoXN6ZGGSAQtwYXN0cnlfc2hvcA",
                "6 thin cake layers, separated by an airy, rich chocolate cream, topped with a crunchy caramel layer, often drizzled with walnuts. This cake is guaranteed to become your preferred choice in any Hungarian confectionery. ",
                arrayListOf(
                    "Eggs\n" +
                            "Flour \n" +
                            "Sugar\n" +
                            "Vanilla essence\n" +
                            "Whipping cream\n" +
                            "Chocolate\n" +
                            "Walnuts"
                )
            )
        )
        foods.add(
            Food(
                "Vadas",
                R.drawable.vadas,
                "https://www.google.com/maps/place/IKON+Restaurant/@47.5298089,21.6224314,17z/data=!3m1!4b1!4m5!3m4!1s0x47470e0cacdbc04b:0xf7a4bc6aab8fec7!8m2!3d47.5298089!4d21.6246201",
                "The Hungarian word “vad” means wild. The dish earned this name due to it originally containing boar meat. It was typically prepared during the celebration of a hunting season. However the orange sauce, made from carrots, is a popular side, paired with pork or beef meat and most often pasta or mashed potatoes.",
                arrayListOf(
                    "Boar/Pork/Beef meat\n" +
                            "Carrots \n" +
                            "Heavy cream\n" +
                            "Sugar\n" +
                            "Spices\n" +
                            "Parsley"
                )
            )
        )
        foods.add(
            Food(
                "Gundel palacsinta",
                R.drawable.gundel,
                "https://www.google.com/maps/place/Don+Pedro+Pizz%C3%A9ria/@47.5299387,21.6311563,17z/data=!3m1!4b1!4m5!3m4!1s0x47470e769f4087bf:0xb4f3fb7508890958!8m2!3d47.5299387!4d21.633345",
                "Have you ever wondered what a cake made of crepes would be like? Well look no fodder because Hungarians are way ahead of you! Soft pancake layers filled with chocolate cream, topped with walnuts or other kind of nuts. There’s two variations to this desert: some places prepare it as a cake, while others sell it as pancakes with chocolate and nuts.",
                arrayListOf(
                    "Eggs\n" +
                            "Flour \n" +
                            "Sugar\n" +
                            "Chocolate\n" +
                            "Walnuts/Nuts"
                )
            )
        )
        foods.add(
            Food(
                "Pöttyös Túró Rudi",
                R.drawable.pottyos,
                "",
                "Túrórudi is a popular Hungarian invention. It’s really simple, yet irresistible: a special type of sweet cheese, covered in dark chocolate. The dark chocolate gives it a crunchy snap as you bite into it, and then the sweet, yet slightly sour cheese creamily spreads in your mouth. As of now there are multiple variations to it: some are covered in white chocolate, some contain fruit jelly or hazelnut cream in the middle. Whichever will end up becoming your favorite, just make sure you try the original, dark chocolate one too , you can find it in any supermarket . ",
                arrayListOf(
                    "Cheese (Tehéntúró)\n" +
                            "Chocolate"
                )
            )
        )
        foods.add(
            Food(
                "Somlói galuska",
                R.drawable.somloi,
                "https://www.google.com/maps/place/PANIIR+%C3%89tterem/@47.5285995,21.6225637,17z/data=!3m1!4b1!4m5!3m4!1s0x47470fea40f9dbaf:0xc65ebf57165a83cb!8m2!3d47.5285161!4d21.6247746",
                "You could even try and make this one at home pretty easily. All you need is some sweet bread or crescent; cut into small pieces, soaked in a mixture of milk, sugar and rum or rum essence, some chocolate topping and whipped cream for decoration. ",
                arrayListOf(
                    "Milk\n" +
                            "Sugar \n" +
                            "Rum\n" +
                            "Chocolate\n" +
                            "Crescent/Your preferred bakeries"
                )
            )
        )
        foods.add(
            Food(
                "Zserbó",
                R.drawable.zserbo,
                "https://www.google.com/maps/place/Lad%C3%A1nyi+Cukr%C3%A1szda+Debrecen/@47.5549338,21.6282569,17z/data=!3m1!4b1!4m5!3m4!1s0x47470d136003fcb1:0x4be162cd4ee7e602!8m2!3d47.5549338!4d21.6304456",
                "Typically 4 layers of thin cake, separated by a mixture of peach jam and walnuts. All this topped with a layer of melted chocolate, which is then left to set and harden, giving the cookie a nice snap when you bite into it. ",
                arrayListOf(
                    "Eggs\n" +
                            "Flour \n" +
                            "Sugar\n" +
                            "Yeast\n" +
                            "Margarin\n" +
                            "Peach jam \n" +
                            "Walnuts\n" +
                            "Chocolate"
                )
            )
        )
    }
    private fun addFaculties(faculties: ArrayList<Faculty>) {
        faculties.add(
            Faculty(
                "Faculty of Agricultural and Food Sciences and Environmental Management",
                R.drawable.facultyofagricultural,
                "The aim of the educational, research and development activities at the Faculty of Agricultural and Food Sciences and  Environmental Management is to satisfy the present and medium term requirements of Hungary, the agricultural sector and the society. The Faculty trains experts at the BSc, MSc and PhD levels in numerous fields of agricultural sciences: classical fields (animal husbandry, crop production and horticulture), environmental management, food processing, game management, nature conservation and crop protection are included in the diverse educational programs.",
                "https://www.google.com/maps/place/Mez%C5%91gazdas%C3%A1g-,+%C3%89lelmiszertudom%C3%A1nyi+%C3%A9s+K%C3%B6rnyezetgazd%C3%A1lkod%C3%A1si+Kar+%22A%22+%C3%A9p%C3%BClet/@47.5476899,21.6022552,15z/data=!4m9!1m2!2m1!1sFaculty+of+Agricultural+and+Food+Sciences+and+Environmental+Management!3m5!1s0x4747120803e93d83:0x3430c943678427c1!8m2!3d47.549246!4d21.6087796!15sCkZGYWN1bHR5IG9mIEFncmljdWx0dXJhbCBhbmQgRm9vZCBTY2llbmNlcyBhbmQgRW52aXJvbm1lbnRhbCBNYW5hZ2VtZW50WkgiRmZhY3VsdHkgb2YgYWdyaWN1bHR1cmFsIGFuZCBmb29kIHNjaWVuY2VzIGFuZCBlbnZpcm9ubWVudGFsIG1hbmFnZW1lbnSSAQp1bml2ZXJzaXR5",
                "https://mek.unideb.hu/en"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Dentistry",
                R.drawable.facultyofdentistry1,
                "The faculty provides internationally recognized education of high standard and aims at training professional dentists confident to work all over the world\n" +
                        "\n" +
                        "the Faculty meets the requirements of the European Union and the degree received is accepted in all EU countries and several other countries around the globe\n" +
                        "\n" +
                        "after establishing the departments of Prosthetics, Periodontics and Anatomy, the Faculty introduced the fields of Dental Biochemistry and Dental Medicine\n" +
                        "\n" +
                        "in 2000, the disciplines of Restorative Dentistry, Surgery, Physiology, Pharmacy, Microbiology and Pathology became parts of the Curriculum of dental studies\n" +
                        "\n" +
                        "the Dentistry Program for English Program Students was established in 2003, and by now, the Faculty of Dentistry has over 700 international students.\n" +
                        "\n" +
                        "the Faculty participates in the Erasmus Program, thus students have the chance to spend a semester or a full academic year at a foreign university in Europe\n" +
                        "\n" +
                        "in 1996, the Faculty was awarded the title of “Center of Excellence” by the Hungarian Accreditation Committee for its educational, research, and remedial achievements",
                "https://www.google.com/maps/place/Faculty+of+Dentistry/@47.558057,21.6231885,17z/data=!3m1!4b1!4m5!3m4!1s0x47470d8c8e98a455:0x4a30bc3f5d9d8284!8m2!3d47.5580799!4d21.6253423",
                "https://edu.unideb.hu/p/faculty-of-dentistry"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Economics and Business",
                R.drawable.facultyofeconomics,
                "The Faculty of Economics and Business is currently the largest faculty of the University of Debrecen with about 4000 students and more than 120 staff members. The Faculty has been created by the merger of two former faculties of the university: the Faculty of Economics and Business Administration and the Faculty of Applied Economics and Rural Development. \n" +
                        " \n" +
                        "\n" +
                        "The Faculty has a very wide scope of education dominated by economics and business administration; however it has a significant variety of programs in agribusiness and rural development. We are proud of the large number of our international students currently in the BA in Business Administration and Management and the MA in International Economy and Business. The attractiveness of our education is indicated by the popularity of the Faculty in terms of incoming Erasmus students as well.",
                "https://www.google.com/maps/place/Faculty+of+Economics,+University+of+Debrecen/@47.5525681,21.6062032,17z/data=!3m1!4b1!4m5!3m4!1s0x47471209a16746a1:0x21d151ec8761f658!8m2!3d47.5525681!4d21.6083919",
                "https://econ.unideb.hu/en"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Engineering",
                R.drawable.facultyofeng,
                "The Faculty of Engineering of the University of Debrecen is at the forefront of the education and training of engineers in the Northern Lowland Region of Hungary. It is a dynamically developing Faculty with over 3000 students and a highly-qualified and enthusiastic teaching staff of about 80 members. The Faculty offers a great variety of BSc, MSc courses and post-graduate training courses tailored to suit the rapidly changing world of engineering and focusing on European and international trends. \n" +
                        "\n" +
                        "\n" +
                        "In order to optimize the quality of training the Faculty continuously strives to expand the number of industry and educational partners at home and abroad. Students are provided with practical knowledge, training and field practice with the help of the numerous prestigious domestic and multi-national industry partners. Debrecen is the industrial centre of the Eastern-Hungarian region providing excellent internship and job opportunities at a growing number of companies such as Thyssenkrupp, Schaeffler, Aventics, Diehl Aviation; and the city is going to be home to a BMW Group plant in the near future. Internship periods are excellent opportunities for students to experience theory put into practice at the most renowned industry representatives and to become more successful in the labor market in this highly competitive sector\n" +
                        "\n" +
                        "\n" +
                        "The Faculty was awarded the Quality Prize in 2011 by the Ministry of Education as a recognition of its efforts in this field.",
                "https://www.google.com/maps/place/University+of+Debrecen,+Faculty+of+Engineering./@47.5365265,21.6388292,17z/data=!3m1!4b1!4m5!3m4!1s0x47470d9319fd6971:0x748c15defc16ca79!8m2!3d47.5365265!4d21.6410179",
                "https://eng.unideb.hu/en"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Health",
                R.drawable.facultyofhealth,
                "The faculty – its center functioning in Nyíregyháza, Hungary – is an educational unit of the University of Debrecen\n" +
                        "\n" +
                        "the Faculty is closely connected to the parent establishment, at the same time it collaborates with other colleges of Nyíregyháza, the College of Nyíregyháza and the St. Atanaz Greek Catholic Theological Academy\n" +
                        "\n" +
                        "besides the training of district nurses, the Faculty made a pledge to run a branch for the training of social workers from the very first moment of its functioning and to make the arrangements for the health information management branch\n" +
                        "\n" +
                        "besides the organization of two branches, that had no previous traditions in Hungary, in the fourth year, the Faculty began the training of qualified nurses",
                "https://www.google.com/maps/place/Debrecen+University+-+Faculty+of+Health/@47.9662676,21.7122174,17z/data=!3m1!4b1!4m5!3m4!1s0x47389f9be6772bbd:0x808b0c62ccccf4bb!8m2!3d47.9662676!4d21.7144061",
                "https://edu.unideb.hu/p/faculty-of-health"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Humanities",
                R.drawable.facultyofhumanities,
                "The Faculty primarily serves the task of training university-level scholars and teachers from the region. For decades, the Faculty has been one of the highest-ranked units of higher education in Hungary. A major asset of the Faculty is its versatility: traditional, classic university degree courses exist alongside the more recently created programs. Another major forte is languages: in addition to bachelor’s courses in Dutch, English, French, German, Italian, Latin, Polish, and Russian, students may also study Bulgarian, Chinese, Finnish, Japanese, Spanish and Ukrainian.",
                "https://www.google.com/maps/place/University+of+Debrecen/@47.5540126,21.6193761,17z/data=!4m8!1m2!2m1!1sDebrecen,+Egyetem+Square+1.,+Main+Building,+third+floor,+Room+No.+333!3m4!1s0x47470df39a92233b:0x158b32cc387080a5!8m2!3d47.5536257!4d21.6215102",
                "https://btk.unideb.hu/en"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Informatics",
                R.drawable.facultyofinformatics,
                "The Faculty of Informatics boasts the only accredited university-level educational program for IT specialists in Eastern Hungary. The six professors, 19 associate professors (senior staff), 29 assistant professors (staff), 16 teaching assistants and 5 graduate computer scientists working at the faculty’s seven departments, represent a formidable pool of intellectual potential, which has earned recognition even at international level.\n" +
                        "\n" +
                        "\n" +
                        "The aim of the Faculty is the training of professionals with complex theoretical knowledge, who are also capable of solving everyday problems in their profession. Practice is given an increasingly significant role in the training. Main research topics include cryptography and computer algebra, information technology, the modelling of information systems and networks, probability theory and stochastic processes, digital image processing, computer graphics, library and information science, and new computational paradigms.\n",
                "https://www.google.com/maps/place/Department+of+Informatics,+University+of+Debrecen/@47.5422882,21.6376674,17z/data=!3m1!4b1!4m5!3m4!1s0x47470ddcc57b63cf:0x8426ebc782bcb06b!8m2!3d47.5423045!4d21.6398395",
                "https://inf.unideb.hu/en"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Law",
                R.drawable.facultyoflaw,
                "Roots of legal education in Debrecen go back to 1742. Today the Faculty is a dynamic, student-oriented and friendly institution that gained several academic excellence awards throughout recent years. This school puts a significant emphasis on high-quality interdisciplinary teaching and research involving legal practitioners and respected academics from the region. The Faculty offers Hungarian and English language programs to students interested in legal and public administration sciences.\n" +
                        "\n" +
                        "\n" +
                        "The international study and research network of the faculty is extensive mainly in Europe and North America having\n" +
                        "cooperation with more than 40 foreign institutions worldwide. The 54 full-time faculty members and around 20 adjunct professors teach and research various aspects of legal and political sciences under 12 departments.",
                "https://www.google.com/maps/place/Debrecen,+Faculty+of+Law,+4028/@47.5433506,21.6395465,17z/data=!3m1!4b1!4m5!3m4!1s0x47470dc34135eec9:0xbe7a2b27f07d9ad9!8m2!3d47.5433506!4d21.6417352",
                "https://jog.unideb.hu/en"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Medicine",
                R.drawable.facultyofmedicine,
                "the Faculty of Medicine of the University of Debrecen was Central Europe's first campus medical school\n" +
                        "\n" +
                        "the University was officially inaugurated on October 23, 1918 and at that time consisted of four faculties: Arts, Science, Theology and Medicine\n" +
                        "\n" +
                        "the Faculty of Medicine became an independent University Medical School under the supervision of the Ministry of Health in 1951",
                "https://www.google.com/maps/place/University+of+Debrecen+Medical+School/@47.5564768,21.6261044,17z/data=!3m1!4b1!4m5!3m4!1s0x47470d8c91ee0325:0xf8e3ad2d6f50939e!8m2!3d47.5564768!4d21.6282931",
                "https://edu.unideb.hu/p/faculty-of-medicine"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Music",
                R.drawable.facultyofmusic,
                "The Faculty of Music at the University of Debrecen has a history of nearly 50 years. The aim of the faculty is to educate musicians who, with their performing skills, theoretical knowledge and highly developed musical abilities, enrich and spread Hungarian and International music culture. They can enrich the repertory of musical knowledge with their sophisticated musical taste and are able to work in musical institutions, professional performing ensembles, religious ensembles and in other occupations that require a musical education.\n" +
                        "\n" +
                        "\n" +
                        "Apart from demanding high level classes of well-known professors and artists, the Faculty provides a great number of  extracurricular activities such as master classes, national and international meetings and competitions, but also remembers to organize entertainment programs.",
                "https://www.google.com/maps/place/Debreceni+Egyetem+Zenem%C5%B1v%C3%A9szeti+Kar/@47.5513479,21.6202039,17z/data=!3m1!4b1!4m5!3m4!1s0x47470d6cf6baf609:0x570930e614022de6!8m2!3d47.5513479!4d21.6223926",
                "https://music.unideb.hu/en"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Pharmacy",
                R.drawable.facultyofpharmacy,
                "the education of pharmacists began within the frameworks of a joint education program between the University Medical School of Debrecen and the former Lajos Kossuth University with the consent of the National Accreditation Committee and the Higher Education Board in 1996\n" +
                        "\n" +
                        "the Faculty of Pharmacy currently consists of six departments:\n" +
                        "\n" +
                        "Pharmacology and Pharmacodynamics\n" +
                        "\u200BBiopharmacy\n" +
                        "Clinical Pharmacology\n" +
                        "Pharmaceutical Technology\n" +
                        "Pharmaceutical Chemistry\n" +
                        "Pharmaceutical Management // Pharmaceutical Surveillance and Economics\n" +
                        "the collaboration between the Faculty of Pharmacy, Faculty of Medicine, and Faculty of Sciences is an ongoing project and an absolutely necessary step for the higher education of pharmacists in the city of Debrecen\n" +
                        "\n" +
                        "the Faculty of Pharmacy offers a dynamic curriculum, which includes a broad base of both didactic and experiential components\n" +
                        "\n" +
                        "practical skills as well as the contribution to the body of pharmaceutical knowledge through scholarly activity and service are also important at the Faculty",
                "https://www.google.com/maps/place/Debrecen,+Faculty+of+Pharmacy,+4032/@47.5589015,21.6225884,17z/data=!3m1!4b1!4m5!3m4!1s0x47470d8c7f32634d:0xadece1d9b4ef2418!8m2!3d47.5589015!4d21.6247771",
                "https://edu.unideb.hu/p/faculty-of-pharmacy"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Public Health",
                R.drawable.facultyofpublichealth,
                "the first faculty of Public Health in Hungary was established by the decision of the Hungarian Government on 1st December 2005\n" +
                        "\n" +
                        "the Faculty came into existence through the merger of the School of Public Health, the Department of Preventive Medicine, the Department of Family Medicine and the Department of Behavioural Sciences of the University of Debrecen\n" +
                        "\n" +
                        "the mission of the Faculty is to\n" +
                        "\n" +
                        "improve the health of the population by developing and maintaining high- and internationally recognized quality training programs, complying with the training needs of the public health and health care institutions, both at the graduate and postgraduate level\n" +
                        "to pursue excellence in research\n" +
                        "provide consultancy\n" +
                        "develop and invest in Faculty staff\n" +
                        "establishment and launching of 5 different postgraduate and one graduate training programs as well as the establishment of a doctoral program were carried out by the teaching staff of the faculty with the effective support of the University of Debrecen and its Medical and Health Science Centre\n" +
                        "\n" +
                        "according to the Bologna process, the Faculty has established and  launched its Bachelor and Master training programs (from 2006 and 2007) in the field of public health and health sciences\n" +
                        "\n" +
                        "with its 2 Bachelor, 4 Master training programs and 6 postgraduate courses, the Faculty offers a rich variety of learning experience at present\n" +
                        "\n" +
                        "two doctoral programs are also available since 2009\n" +
                        "\n" +
                        "the Faculty is an internationally recognized workshop of public health research",
                "https://www.google.com/maps/place/University+of+Debercen+faculty+of+public+health+educational+office/@47.5424022,21.6388315,17z/data=!3m1!4b1!4m5!3m4!1s0x47470ddcb4934dd9:0xffe751fd562c95e7!8m2!3d47.5423782!4d21.6410912",
                "http://www.nk.unideb.hu/index.php?langid=en"

            )
        )
        faculties.add(
            Faculty(
                "Faculty of Science and Technology",
                R.drawable.facultyofscienceandtech,
                "The Faculty was established in 1949, and now plays a leading role in training professionals, teachers and experts in science and technology in the Northern Lowland Region of Hungary. It cultivates, mediates and teaches a number of fields of biology, physics, geography, chemistry, environmental science and mathematics at an advanced level. The Faculty enables students to acquire a complex knowledge of natural phenomena in a practice-oriented way.\n" +
                        "\n" +
                        "\n" +
                        "The Faculty has a teaching and research staff numbering over 200, who are engaged in significant research activities both in Hungarian and in international teams and actively participate in various professional organizations. The institutes of the Faculty have continuously expanded relationships with the corporate world in the fields of education, applied research and innovation.",
                "https://www.google.com/maps/place/DE+K%C3%A9mia+%C3%89p%C3%BClet/@47.554684,21.618098,17z/data=!3m1!4b1!4m5!3m4!1s0x47470df48e62fe51:0x214a8720652f2d53!8m2!3d47.554684!4d21.6202867",
                "https://ttk.unideb.hu/en"

            )
        )


    }
    private fun addPhrases(phrases: ArrayList<Phrase>) {
        phrases.add(
            Phrase("Hello", "Szia !" , "szia")
        )
        phrases.add(
            Phrase("No", "Nem" , "nem")
        )
        phrases.add(
            Phrase("Yes", "Igen" , "igen")
        )
        phrases.add(
            Phrase("and", "és" , "es")
        )
        phrases.add(
            Phrase("How are you ?", "Hogy vagy" , "hogyvagy")
        )
        phrases.add(
            Phrase("How old are you ?", "Hány éves vagy" , "hanyeves")
        )
        phrases.add(
            Phrase("I'm good", "Jól vagyok" , "jolvagyok")
        )
        phrases.add(
            Phrase("What are you doing ?", "Mit csinálsz" , "mitcsinalsz")
        )
        phrases.add(
            Phrase("Nothing", "Semmit" , "semmit")
        )
        phrases.add(
            Phrase("Thank you", "Köszönöm" , "koszonom")
        )
        phrases.add(
            Phrase("You're welcome", "szívesen" , "szivesen")
        )
        phrases.add(
            Phrase("Goodbye", "Viszlát" , "viszlat")
        )
        phrases.add(
            Phrase("Good day", "Jó napot!" , "jonapot")
        )
        phrases.add(
            Phrase("Good morning", "Jó reggelt!" , "joreggelt")
        )
        phrases.add(
            Phrase("Good evening", "Jó estét!" , "joestet")
        )
        phrases.add(
            Phrase("Good night", "Jó éjszakát!" , "joejszakat")
        )
        phrases.add(
            Phrase("Good appetite", "Jó étvágyat!" , "joetvagyat")
        )
        phrases.add(
            Phrase("Cheers", "Egészségedre!" , "egeszsegedre")
        )
        phrases.add(
            Phrase("Excuse me", "Elnézést!" , "elnezest")
        )
        phrases.add(
            Phrase("Sorry", "Bocsánat" , "bocsanat")
        )
        phrases.add(
            Phrase("Sweet dreams", "Szép álmokat!" , "szepalmokat")
        )
        phrases.add(
            Phrase("How much does it cost ?", "Mennyibe kerül" , "mennyibe")
        )
        phrases.add(
            Phrase("Train station", "Vasútállomás" , "vasutallomas")
        )
        phrases.add(
            Phrase("Bus stop", "Buszmegálló" , "buszmegallo")
        )

    }
    private fun addInfo(infos: ArrayList<RandomInfo>) {
        infos.add(
            RandomInfo(
                "Foodpanda",
                R.drawable.foodpanda,
                "Fast-food and groceries delivery service",
                "https://www.foodpanda.hu/en/?r=1&gclid=Cj0KCQjwxtSSBhDYARIsAEn0thQM7-493ntkRlWoit45UqT9NE61nWLlux56pAw1aOFCT3QQDChXJ-kaAj-DEALw_wcB"

            )
        )
        infos.add(
            RandomInfo(
                "Wolt",
                R.drawable.wolt,
                "Fast-food and groceries delivery service",
                "https://wolt.com/en/hun?pid"
            )
        )
        infos.add(
            RandomInfo(
                "VisitMe",
                R.drawable.visitme,
                "Food delivery service",
                "https://www.visitme.hu/"
            )
        )
        infos.add(
            RandomInfo(
                "Tailor",
                R.drawable.tailor,
                "Tarcsai-Módi Bt.",
                "https://www.google.com/maps/place/Tarcsai-M%C3%B3di+Bt./@47.5169152,21.4531979,12z/data=!4m9!1m2!2m1!1stailor+debrecen!3m5!1s0x474713058920fe75:0xba21c11583521ba7!8m2!3d47.5953183!4d21.5724895!15sCg90YWlsb3IgZGVicmVjZW5aESIPdGFpbG9yIGRlYnJlY2VukgELbWVuc190YWlsb3I"
            )
        )
        infos.add(
            RandomInfo(
                "Bus App",
                R.drawable.busapp,
                "Debreceni Menetrend",
                "https://menetrend.derke.hu/"
            )
        )
        infos.add(
            RandomInfo(
                "Doctor Appointment",
                R.drawable.doctor,
                "",
                "https://udgpoffice.setmore.com/services"
            )
        )
        infos.add(
            RandomInfo(
                "Flat rental",
                R.drawable.flat,
                "",
                "https://www.facebook.com/groups/flatforrentdebrecen"
            )
        )
        infos.add(
            RandomInfo(
                "Events",
                R.drawable.events,
                "",
                "https://www.debrecen.hu/en/tourist/programmes/"
            )
        )
    }
    private fun addDocuments(documents: ArrayList<Document>) {
        documents.add(
            Document(
                "Student Card",
                R.drawable.studentcard,
                "http://www.troubleshooter.hu/more.php?id=6",
                "https://www.google.com/maps/place/Debreceni+Korm%C3%A1nyablak+(Piac+utca)/@47.5269951,21.6258286,18.77z/data=!4m5!3m4!1s0x47470e725766f9cd:0x9615a6bac5bd985c!8m2!3d47.5267669!4d21.6266923"
            )
        )
        documents.add(
            Document(
                "TAJ Card (Health Insurance Card)",
                R.drawable.tajcard,
                "https://edu.unideb.hu/p/health-insurance",
                "https://www.google.com/maps/place/Health+insurance+fund/@47.5340222,21.6245032,15z/data=!4m2!3m1!1s0x0:0xd7b31569205e405d?sa=X&ved=2ahUKEwixjM-OtI33AhUZ_7sIHRG4B0cQ_BJ6BAhFEAU"
            )
        )
        documents.add(
            Document(
                "Residence Permit",
                R.drawable.residencecard,
                "https://edu.unideb.hu/p/immigration-office",
                "https://goo.gl/maps/7ikE1WkC8hrjaz816"
            )
        )
        documents.add(
            Document(
                "Bus Card",
                R.drawable.buscard1,
                "http://www.troubleshooter.hu/more.php?id=7",
                "https://www.google.com/maps/search/debrecen+posta/@47.5332558,21.6254339,16z/data=!3m1!4b1"
            )
        )
        documents.add(
            Document(
                "Tax Card",
                R.drawable.taxcard,
                "https://mobi.unideb.hu/tax_ID",
                "https://www.google.com/maps/place/NAV+Hajdu-Bihar+County+Tax+Board/@47.5287717,21.6431613,18.84z/data=!4m13!1m7!3m6!1s0x47470e7855124735:0x217fcf038700d2d5!2sDebrecen,+Farakt%C3%A1r+u.+29,+4029!3b1!8m2!3d47.528682!4d21.643835!3m4!1s0x47470e79022c139f:0x99b1a804262912ff!8m2!3d47.528162!4d21.6440655"
            )
        )
    }
    private fun addJobs(jobs: ArrayList<Job>) {
        jobs.add(
            Job(
                "Meló-Diák",
                R.drawable.melodiak,
                "Debrecen, Széchenyi u. 48, 4025",
                "+36 52 430 738",
                "https://www.melodiak.hu/irodak/melo-diak-debrecen"
            )
        )
        jobs.add(
            Job(
                "Műisz",
                R.drawable.muisz,
                "Debrecen, Bem tér 30, 4027",
                "+36 20 444 0411",
                "https://muisz.hu/en/home/"
            )
        )
    }
    private fun addLandMarks(landMarks: ArrayList<LandMark>) {
        landMarks.add(
            LandMark(
                "Reformed Great Church of Debrecen",
                R.drawable.reformed_great_hurch,
                "The Reformed Great Church or Great Reformed Church in Debrecen is located in the city of Debrecen. It stands in the city centre, between Kossuth square and Kalvin square. It is the symbol of the Protestant Church in Hungary, and it is because of this church that Debrecen is sometimes referred to as \"the Calvinist Rome\". With a ground space of 1500 m² it is the largest Protestant church in Hungary. It also has the largest bell of all Hungarian Protestant churches. The Great Church was built between 1805 and 1824 in the neoclassical style.",
                "https://www.google.com/maps/place/Reformed+Great+Church+of+Debrecen/@47.5320787,21.6243388,15z/data=!4m5!3m4!1s0x0:0x86950f7a0a6bcbfb!8m2!3d47.5320787!4d21.6243388"
            )
        )
        landMarks.add(LandMark(
            "Great Forest Park",
            R.drawable.greatforestpark,
        "Leafy spot with a lake & woodsy trails",
        "https://www.google.com/maps/place/Great+Forest+Park/@47.5521714,21.6260684,15z/data=!4m5!3m4!1s0x0:0xd6badf25007d0e71!8m2!3d47.5521714!4d21.6260684",
        ))
        landMarks.add(LandMark(
            "Déri Museum",
            R.drawable.derimuseum,
            "Cultural heritage in a baroque building",
            "https://www.google.com/maps/place/D%C3%A9ri+Museum/@47.533048,21.622093,15z/data=!4m2!3m1!1s0x0:0x2c5debed6ee052df?sa=X&ved=2ahUKEwiPoq3x8o73AhXohf0HHUbXCpAQ_BJ6BAhVEAU",
        ))
        landMarks.add(LandMark(
            "Debrecen Zoo and Amusement Park",
            R.drawable.zoo,
            "Endangered animals & roller coasters",
            "https://www.google.com/maps/place/Debrecen+Zoo+and+Amusement+Park/@47.5524,21.6333999,15z/data=!4m5!3m4!1s0x0:0xd1fec478b2b64d6a!8m2!3d47.5524!4d21.6333999?hl=en-HU",
        ))
        landMarks.add(LandMark(
            "Aquaticum Mediterrán Élményfürdő",
            R.drawable.aquaticum,
            "Laid-back thermal spa hotel offering indoor & open-air hot tubs, plus a water park & dining.",
            "https://www.google.com/maps/place/Aquaticum+Mediterr%C3%A1n+%C3%89lm%C3%A9nyf%C3%BCrd%C5%91/@47.5529538,21.6296895,15z/data=!4m5!3m4!1s0x0:0xff76a2a16b8972ba!8m2!3d47.5529538!4d21.6296895",
        ))
    }
    private fun addTransports(transports: ArrayList<Transport>) {
        transports.add(
            Transport(
                "Taxi", R.drawable.taxi, arrayListOf(
                    SportPlace(
                        "City Taxi",
                        "http://www.citytaxidebrecen.hu/hu/fooldal",
                        R.drawable.citytaxi
                    ),
                    SportPlace(
                        "Főnix Taxi",
                        "http://www.fonixtaxi.hu/",
                        R.drawable.fonixtaxi
                    ),
                    SportPlace(
                        "Taxi 4000 Debrecen",
                        "https://www.facebook.com/taxi4000debrecen/",
                        R.drawable.taxi4000debrecen
                    ),
                    SportPlace(
                        "Bolt",
                        "https://bolt.eu/",
                        R.drawable.bolt
                    )
                )
            )
        )
        transports.add(
            Transport(
                "Bus", R.drawable.busmenu, arrayListOf(
                    SportPlace(
                        "DKV",
                        "https://www.dkv.hu/",
                        R.drawable.dkv
                    ),
                    SportPlace(
                        "Volan Busz",
                        "https://www.volanbusz.hu/en",
                        R.drawable.volanbus
                    )

                )
            )
        )
        transports.add(
            Transport(
                "Train", R.drawable.mav, arrayListOf(
                    SportPlace(
                        "Mav Start",
                        "https://www.mavcsoport.hu/en",
                R.drawable.mav2
                    )
                )
            )
        )
    }
    private fun addSports(sports: ArrayList<Sport>) {
        sports.add(
            Sport(
                "Football",
                R.drawable.football,
                arrayListOf(
                    SportPlace("DEAC University Sports Center",
                        "https://www.google.com/maps/place/DEAC+University+Sports+Center/@47.5557114,21.6198493,16z/data=!4m9!1m2!2m1!1sdeac!3m5!1s0x47470df510ea9155:0x9c33a3523b1bf5f9!8m2!3d47.554866!4d21.6170382!15sCgRkZWFjkgEOYXRobGV0aWNfZmllbGQ",
                        R.drawable.footballdeac1
                    ),
                    SportPlace(
                        "DEAC AstroTurf field",
                        "https://www.google.com/maps/place/DEAC+AstroTurf+field/@47.5552358,21.6171146,17.25z/data=!4m9!1m2!2m1!1sdeac!3m5!1s0x47470d4e39c153f1:0xe8b3ef89af9665af!8m2!3d47.5563041!4d21.6176317!15sCgRkZWFjkgEKcGxheWdyb3VuZA",
                        R.drawable.footballdeac2
                    ),
                    SportPlace(
                        "DE OEC műfüves focipálya",
                        "https://www.google.com/maps/place/DE+OEC+m%C5%B1f%C3%BCves+focip%C3%A1lya+%2F+artifical+grass+minifootball+field/@47.5592949,21.6232478,19.25z/data=!4m8!1m2!2m1!1sdeac!3m4!1s0x47470d78b8cbc009:0x5a95e64d6c708e7!8m2!3d47.559336!4d21.6231436",
                        R.drawable.football3
                    ),
                    SportPlace(
                        "Balmazújváros Football Club Böszörményi úti Sportcentrum",
                        "https://www.google.com/maps/place/Balmaz%C3%BAjv%C3%A1ros+Football+Club+B%C3%B6sz%C3%B6rm%C3%A9nyi+%C3%BAti+Sportcentrum/@47.6240105,21.3543835,16.5z/data=!4m9!1m2!2m1!1sfootball!3m5!1s0x47473f1914b9c84d:0x516cfcf59eeb221c!8m2!3d47.6255703!4d21.3566123!15sCghmb290YmFsbJIBC3Nwb3J0c19jbHVi",
                        R.drawable.football
                    ),
                    SportPlace(
                        "G4 Fitness",
                        "https://www.google.com/maps/place/G4+Fitness/@47.5208238,21.6473722,14z/data=!4m5!3m4!1s0x47470e890606981f:0xe38f965e1223b7e4!8m2!3d47.5162077!4d21.6494934",
                        R.drawable.football5
                    ),
                )
            )
        )
        sports.add(
            Sport(
                "Basketball",
                R.drawable.basketball,
                arrayListOf(
                    SportPlace(
                        "DEAC Sports Center",
                        "https://www.google.com/maps/@47.5566013,21.6188804,3a,75y,237.36h,90t/data=!3m7!1e1!3m5!1sQleOGJa8pf2ljGdh6gCAdQ!2e0!6shttps:%2F%2Fstreetviewpixels-pa.googleapis.com%2Fv1%2Fthumbnail%3Fpanoid%3DQleOGJa8pf2ljGdh6gCAdQ%26cb_client%3Dsearch.revgeo_and_fetch.gps%26w%3D96%26h%3D64%26yaw%3D237.36372%26pitch%3D0%26thumbfov%3D100!7i13312!8i6656",
                        R.drawable.basketball1
                    ),
                    SportPlace(
                        "Klinikai Campus Tornacsarnok",
                        "https://www.google.com/maps/place/Klinikai+Campus+Tornacsarnok/@47.5618897,21.6238394,20.25z/data=!4m8!1m2!2m1!1sauguszta+sport!3m4!1s0x47470d896c2b0701:0x78bfb1f06ba72bc3!8m2!3d47.5621705!4d21.6247394",
                        R.drawable.athleticbasketball
                    ),
                    SportPlace(
                        "Debreceni Egyetem Sporttudományi Oktatóközpont",
                        "https://www.google.com/maps/place/Debreceni+Egyetem+Sporttudom%C3%A1nyi+Oktat%C3%B3k%C3%B6zpont/@47.5566013,21.6188804,18z/data=!4m5!3m4!1s0x47470df4e11c524d:0xbf8edcdc8938f48b!8m2!3d47.5558022!4d21.6185913",
                        R.drawable.basketball3
                    )
                )
            )
        )

        sports.add(
            Sport(
                "Volleyball",
                R.drawable.volley,
                arrayListOf(
                    SportPlace(
                        "Debreceni Egyetem Sporttudományi Oktatóközpont",
                        "https://www.google.com/maps/place/Debreceni+Egyetem+Sporttudom%C3%A1nyi+Oktat%C3%B3k%C3%B6zpont/@47.5566013,21.6188804,18z/data=!4m5!3m4!1s0x47470df4e11c524d:0xbf8edcdc8938f48b!8m2!3d47.5558022!4d21.6185913",
                        R.drawable.volleyball
                    ),
                )
            )
        )
        sports.add(
            Sport(
                "Spas",
                R.drawable.spa,
                arrayListOf(
                    SportPlace(
                        "Aquaticum Strand",
                        "https://www.google.com/maps/place/Aquaticum+Strand/@47.555268,21.6244587,17.08z/data=!4m5!3m4!1s0x47470d8d5be7e1b1:0x8a205feb4b361bce!8m2!3d47.5544317!4d21.6297795",
                        R.drawable.spa1
                    ),
                    SportPlace(
                        "Aquaticum Termálfürdő",
                        "https://www.google.com/maps/place/Aquaticum+Term%C3%A1lf%C3%BCrd%C5%91/@47.5527121,21.6278172,17.82z/data=!4m5!3m4!1s0x47470d8d4668bed3:0x3019e297652ae882!8m2!3d47.5518542!4d21.6283033",
                        R.drawable.spa2
                    ),
                    SportPlace(
                        "Kerekestelep Thermal Camping",
                        "https://www.google.com/maps/place/Kerekestelep+Thermal+Camping/@47.507774,21.6348203,17z/data=!3m1!4b1!4m5!3m4!1s0x47470e9b520aedb7:0x4d0b2ca183f48a62!8m2!3d47.507774!4d21.637009",
                        R.drawable.spa3
                    )
                )
            )
        )
        sports.add(
            Sport(
                "Gyms",
                R.drawable.gym,
                arrayListOf(
                    SportPlace(
                        "G4 Fitness",
                        "https://www.google.com/maps/place/G4+Fitness/@47.5208238,21.6473722,14z/data=!4m5!3m4!1s0x47470e890606981f:0xe38f965e1223b7e4!8m2!3d47.5162077!4d21.6494934",
                        R.drawable.gym1
                    ),
                    SportPlace(
                        "UNIFIT Fitness & Gym Center",
                        "https://www.google.com/maps/place/UNIFIT+Fitness+%26+Gym+Center/@47.5533503,21.6317237,17z/data=!3m1!4b1!4m5!3m4!1s0x47470decd32516d5:0x82fab1ac6928bd60!8m2!3d47.5533503!4d21.6339124",
                        R.drawable.gym2
                    ),
                    SportPlace(
                        "Corpus Fitness Studio Kft.",
                        "https://www.google.com/maps/place/Corpus+Fitness+Studio+Kft./@47.54945,21.6340213,17z/data=!3m1!4b1!4m5!3m4!1s0x47470debcc460bfb:0x8f6eb9530993529d!8m2!3d47.54945!4d21.63621",
                        R.drawable.gym3
                    ),
                    SportPlace(
                        "Cutler Fitness",
                        "https://www.google.com/maps/place/Cutler+Fitness/@47.5476903,21.6088213,17z/data=!3m1!4b1!4m5!3m4!1s0x47470df83e9b3f0d:0x9d7d2e82f60ad58e!8m2!3d47.5477305!4d21.6110066",
                        R.drawable.gym4
                    )
                )
            )
        )
    }
    private fun addHolidays(holidays: ArrayList<Holiday>) {
        holidays.add(
            Holiday(
                "New Year's Day",
                "Újév",
                R.drawable.newyear,
                "1 January",
                "Making noise at midnight is very important. Partly, so that everybody is awake and will work hard in the next year and partly," +
                        "so that the flock turns to its other side at the beginning of the next year. Bigger boys went from house to house and alarmed the stock by tinkling and snapping whips." +
                        "It was believed that this way they ensured the health and reproductiveness of the animals. The boys were then served with wine, schnapps, and desserts and gifted with different presents."
            )
        )
        holidays.add(
            Holiday(
                "Revolution Memorial Day",
                "Nemzeti ünnep",
                R.drawable.revolution,
                "15 March",
                "Revolution was in the air across Europe in 1848, with insurrections arising from the isle of Sicily to the royal palace of Paris to the streets of Berlin and beyond." +
                        "This widespread wave of rebellion also swept through Hungary in the early months of that year, erupting into an insurgency that ignited in Budapest with the dramatic recital of a poem " +
                        "that still stirs the souls of patriotic Magyars to this day. While many exact details from the Hungarian Revolution of 1848 are now obscured by history, the rebellion definitely " +
                        "began on March 15th – now solemnly observed as a national holiday . Dont forget to pin your cockade shown in the picture !"
            )
        )
        holidays.add(
            Holiday(
                "Good Friday",
                "Nagypéntek",
                R.drawable.goodfriday,
                "Friday preceding Easter Sunday",
                "Good Friday is a Christian holiday commemorating the crucifixion of Jesus and his death at Calvary.Good Friday is a day for housecleaning and decorating eggs.  It is also known as " +
                        "Holy Friday, Great Friday, and Black Friday.The stock markets are closed on Good Friday but the foreign exchange and bond trading markets open for a partial business day.Most retail stores " +
                        "remain open, while some of them may close early.Public schools and universities are often closed on Good Friday, either as a holiday of its own, or as part of spring break."
            )
        )
        holidays.add(
            Holiday(
                "Easter Sunday",
                "Húsvétvasárnap",
                R.drawable.eastersunday,
                "Between 22 March and 25 April",
                "During this time, find eggs decorated with Hungarian motifs, including those that mimic Hungarian embroidery in colorful floral designs. Simple, homemade eggs may bear the imprint of a " +
                        "leaf that was secured to it during the dying process. Dark red Easter eggs, sometimes with a white design, recall the spilling of Christ's blood. The most difficult to decorate Easter " +
                        "eggs in Hungary is with small metal horseshoes, requiring expertise by the egg decorator, whose hands must be steady and agility advanced enough so as not to break the eggshell when " +
                        "affixing the horseshoe onto the blown egg."
            )
        )
        holidays.add(
            Holiday(
                "Easter Monday",
                "Húsvéthétfő",
                R.drawable.eastermonday,
                "Monday following Easter Sunday",
                "In Hungary the various celebrations and traditions are linked to Christian traditions, pagan rituals and modern customs as well. One of these traditions is watering or sprinkling the girls " +
                        "and women on Easter Monday. It is based on a former pagan fertility ritual and originally the “victims” were young maidens, but nowadays men do this to women of all ages, relatives, " +
                        "friends, too. First boys recite a cute little poem to girls and then sprinkle them with perfume so that they don’t wilt. In some villages or smaller towns on the Hungarian countryside " +
                        "they still follow the older traditions: boys do not use a little amount of perfume to sprinkle girls, but a huge bucket of cold water! This way our women won’t wilt for sure!"
            )
        )
        holidays.add(
            Holiday(
                "Labour Day",
                "A munka ünnepe",
                R.drawable.labourday,
                "1 May",
                "Labor Day has become an important part of the Hungarian holiday calendar.May Day, or Labor Day, is celebrated in most countries around the world and signals the start of spring " +
                        "as well as the celebration of workers.Labor Day came into prominence in the late eighteenth and early nineteenth centuries when factory workers’ human rights were violated with extreme " +
                        "work conditions.Hungarians usually celebrate the day with parades, picnics, concerts, rallies and government events to celebrate workers and labor unions." +
                        "Labor Day celebrations will be held on the banks of the Danube and throughout Budapest, and will be marked up and down the country."
            )
        )
        holidays.add(
            Holiday(
                "Pentecost",
                "Pünkösd",
                R.drawable.pentecost,
                "50 days after Easter Sunday",
                "The end of spring/beginning of summer marks Pentecost, a celebration important in both folk traditions and religious lives. The Hungarian Pentecost traditions are mainly connected to " +
                        "the Christian holiday, but some of the elements came from the Pagan times.Most people take advantage of the long weekend and travel around. The wellness centres and spas are always full " +
                        "this time of the year. Those who take the religious aspect of the holiday seriously usually visit the Csíksomlyó búcsú, which is the Csíkcsomlyó pilgrimage in Transylvania. " +
                        "The Csíksomlyó pilgrimage The Csíksomlyó pilgrimage is basically the largest Catholic celebration of the year for Hungarians. It is an annual gathering in Csíksomlyó, Transylvania, " +
                        "which attracts between 50,000 and 100,000 attendees each year."
            )
        )
        holidays.add(
            Holiday(
                "Pentecost Monday",
                "Pünkösdhétfő",
                R.drawable.pentecostmonday,
                "Monday after Pentecost",
                "Whit Monday, or Pentecost Monday, is a Christian holiday. It is the day after Pentecost, also known as Whit Sunday or Whitsunday, which commemorates the descent of the Holy Ghost upon " +
                        "the disciples of Jesus Christ, according to the New Testament of the Bible.Shops, markets, banks etc. will be closed, a couple of great festivals and programs await visitors in Hungary " +
                        "over the weekend."
            )
        )
        holidays.add(
            Holiday(
                "State Foundation Day",
                "Az államalapítás ünnepe",
                R.drawable.statefoundation,
                "20 August",
                "It was on this day in 1038 that the first Christian king of Hungary, St. Stephen I died, five days after he offered the country for Virgin Mary on his deathbed. " +
                        "He became the first canonized saint in Hungary’s history. He was also the monarch who turned Hungary into a legitimate Christian state after about a century of Paganism, so he can be " +
                        "considered the state-founder of the country.No one works on this day: instead, there is a huge celebration with the hoisting of the national flag on Kossuth Square in Budapest, " +
                        "as well as fascinating fireworks in the night.Catholic believers also attend special masses hosted exclusively for this event.This day also marks the Hungarian Festival of the New Bread. " +
                        "In many locations in Hungary and even in larger Hungarian communities beyond the border (like Transylvania), the blessing or slicing off a loaf of bread are parts of the celebration."
            )
        )
        holidays.add(
            Holiday(
                "National Day",
                "Nemzeti ünnep",
                R.drawable.nationalday,
                "23 October",
                "October 23 is a day that commemorates the 1956 Hungarian revolution and is marked by a range of national events and a public holiday. A number of events will commemorate the day from free " +
                        "exhibitions to an open day at the Hungarian Parliament. With many taking Friday off as well, this will be an extra long weekend for some, so there'll be a more relaxed vibe in the city." +
                        "The date is when, in 1956, Hungarians began to rise up against Soviet occupation. On this day peaceful protests calling for free elections and a free press (among other things) started " +
                        "what would become a weeks-long bloody freedom fight in which thousands would die. In the end, in early November, the revolution was crushed and Soviet tanks rolled into Budapest and a " +
                        "Soviet controlled government was reinstated. Despite this the revolution of 1956 is an important event in Hungary's history and many pay their respects to the people who fought for " +
                        "Hungary's freedom - especially the many young men and women who gave their lives - or their own personal freedom - for the cause."
            )
        )
        holidays.add(
            Holiday(
                "All Saints Day",
                "Mindenszentek",
                R.drawable.allsaints,
                "1 November",
                "Every November 1st, graveyards all over Hungary are filled with a solemn spirit as gathered family members pay a visit to the cemeteries where their deceased relatives are buried, " +
                        "cleaning their gravesites and tombstones while adorning them with beautiful bouquets; as darkness descends upon the day and the air is filled with an autumnal chill, they light " +
                        "commemorative candles to honor their dearly departed. Even though this national holiday is not the most delightful event of the year, it is a deeply rooted tradition in Hungarian culture, " +
                        "and is not regarded as an overly despondent occasion.Hungarian families to make a pilgrimage to the tombstones of their departed friends and relatives, to clean and decorate them with " +
                        "flowers – often with seasonal chrysanthemums – and place commemorative candles on the tombstones, which, based on Christian traditions, represent eternal light. According to folklore, " +
                        "on this day there is a special bond between the living and the dead, and as there are divergent beliefs in the different regions of Hungary, traditional customs vary from village to village."
            )
        )
        holidays.add(
            Holiday(
                "Christmas",
                "Karácsony",
                R.drawable.christmas,
                "24-26 December",
                "The Christmas and gift-giving season starts relatively early compared to other cultures, with the Christmas decorations and markets all over the cities selling hot wine and Kürtőskalács" +
                        "the Santa-like figure, or Hungarian version of Saint Nicholas, Mikulás (or Szent Miklós) " +
                        "traditionally visiting the homes of Hungarian children on the night of 5 December, on the eve of Saint Nicholas Feast Day, 6 December.Although the role of gift-giver on Christmas Day " +
                        "itself is assigned to the Christ Child, on the night before St. Nicholas Day Hungarian children traditionally place a boot on their windowsill waiting for Mikuláš to come by and fill it " +
                        "with treats.There is no Mrs. Mikulás in Hungary. In Hungary, Mikulás often comes with an assistant: a 'Krampusz' or locally called 'Čert', a Devil, who comes to scare and punish bad " +
                        "behaving children. Although even those, who behaved badly just get a warning in form of raw potato or charcoal instead of candy, which good behaving child gets from the other assistant " +
                        "'Angel' .To expatriate Hungarians and those non-natives of Hungarian lineage, the celebration is often referred to as 'Hungarian Christmas'." +
                        "In the traditional Nicholas-walk, on 6 December, St. Nicholas comes clothed in a bishop's attire, a long red coat and a red cap on his head, holding a shepherd's crook in one hand, and " +
                        "carrying a sack full of gifts on his back. He cannot be seen because he arrives in the middle of the night when good little children are already fast asleep, so you'd better not try to " +
                        "stay up so late, otherwise he won't give you any presents, only a birch stick (virgács).Before 24 December, people decorate their houses and start to cook and bake. At Christmas, the " +
                        "family members come together and celebrate. On 24 December, people decorate the tree with ornaments and put the wrapped presents under it. On Christmas Eve, which is the day before " +
                        "Christmas Day, young children are waiting for the arrival of Jesus and especially for the presents. Gift-giving is done after the meal, and after singing carols around the tree." +
                        "On Holy Night, Hungarians listen to holiday songs such as 'Silent Night' and sing or attend Christmas mass. They also burn candles on the Advent wreath during the four weeks before Christmas."
            )
        )
    }

    private fun initializeFoods() {
        supportActionBar?.title = "Food"
        setContentView(R.layout.activity_food)
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val foods: ArrayList<Food> = ArrayList()
        addFoods(foods)
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)
        foodRecyclerView.adapter = FoodAdapter(foods)
    }
    private fun initializeDocuments(){
        supportActionBar?.title = "Official Documents"
        setContentView(R.layout.activity_official_documents)
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val documents: ArrayList<Document> = ArrayList()
        addDocuments(documents)
        documentsRecyclerView.layoutManager = LinearLayoutManager(this)
        documentsRecyclerView.adapter = DocumentsAdapter(documents)
    }
    private fun initializeJobs(){
        setContentView(R.layout.activity_jobs)
        supportActionBar?.title = "Jobs"
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val jobs: ArrayList<Job> = ArrayList()
        addJobs(jobs)
        jobRecyclerView.layoutManager = LinearLayoutManager(this)
        jobRecyclerView.adapter = JobAdapter(jobs)
    }
    private fun initializeLandMarks(){
        setContentView(R.layout.activity_land_marks)
        supportActionBar?.title = "Landmarks"
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val landmarks: ArrayList<LandMark> = ArrayList()
        addLandMarks(landmarks)
        landMarksRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        landMarksRecyclerView.adapter = LandMarksAdapter(landmarks)
    }
    private fun initializeTransport(){
        setContentView(R.layout.activity_transport)
        supportActionBar?.title = "Transport"
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val transports: ArrayList<Transport> = ArrayList()
        addTransports(transports)
        transportRecyclerView.layoutManager = LinearLayoutManager(this)
        transportRecyclerView.adapter = TransportAdapter(transports)
    }
    private fun initializeSports(){
        setContentView(R.layout.activity_sports)
        supportActionBar?.title = "Sports"
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val sports: ArrayList<Sport> = ArrayList()
        addSports(sports)
        sportRecyclerView.layoutManager = GridLayoutManager(this, 1)
        sportRecyclerView.adapter = SportsAdapter(sports)
    }
    private fun initializeHolidays(){
        setContentView(R.layout.activity_holidays)
        supportActionBar?.title = "National Holidays"
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val holidays: ArrayList<Holiday> = ArrayList()
        addHolidays(holidays)
        holidayRecyclerView.layoutManager = GridLayoutManager(this, 1)
        holidayRecyclerView.adapter = HolidayAdapter(holidays)
    }
    private fun initializeUniversity(){
        setContentView(R.layout.activity_university)
        supportActionBar?.title = "Pécs University"
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val faculties: ArrayList<Faculty> = ArrayList()
        addFaculties(faculties)
        universityRecyclerView.layoutManager = GridLayoutManager(this, 1)
        universityRecyclerView.adapter = UniversityAdapter(faculties)
    }
    private fun initializePhrases(){
        setContentView(R.layout.activity_phrases)
        supportActionBar?.title = "Hungarian Phrases"
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val phrases: ArrayList<Phrase> = ArrayList()
        addPhrases(phrases)
        englishFlag.setImageResource(R.drawable.english)
        hungarianFlag.setImageResource(R.drawable.hungarian)
        listen.setImageResource(R.drawable.listen)
        phrasesRecyclerView.layoutManager = LinearLayoutManager(this)
        phrasesRecyclerView.adapter = PhrasesAdapter(phrases)
    }
    private fun initializeRandomInfo(){
        setContentView(R.layout.activity_random_info)
        supportActionBar?.title = "Random Info"
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
        val infos: ArrayList<RandomInfo> = ArrayList()
        addInfo(infos)
        randomInfoRecyclerView.layoutManager = LinearLayoutManager(this)
        randomInfoRecyclerView.adapter = RandomInfoAdapter(infos)
    }
    private fun initializeAskUs(){
        setContentView(R.layout.activity_ask_us)
        supportActionBar?.title = "Ask Us"
        val adRequest = AdRequest.Builder().build()
        bannerPrimary = findViewById(R.id.bannerPrimary)
        bannerPrimary.loadAd(adRequest)
    }
}

