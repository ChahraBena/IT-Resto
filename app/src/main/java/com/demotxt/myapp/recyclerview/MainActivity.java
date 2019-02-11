package com.demotxt.myapp.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Resto> lstResto ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstResto = new ArrayList<>();
        lstResto.add(new Resto("Francescana","Categorie Book","Ut enim benefici liberalesque sumus, non ut exigamus gratiam (neque enim beneficium faeneramur sed natura propensi ad liberalitatem sumus), sic amicitiam non spe mercedis adducti sed quod omnis eius fructus in ipso amore inest, expetendam putamus.\n",
                 R.drawable.rest_img_1,
                "fb.com/Francescana",
                "021459628",
                "Francescana@gmail.com",
                "Twitter/@Francescana",
                "Adresse Resto 1"
                ));
        lstResto.add(new Resto("Cellar Roca","Categorie Book","Dum haec in oriente aguntur, Arelate hiemem agens Constantius post theatralis ludos atque circenses ambitioso editos apparatu diem sextum idus Octobres, qui imperii eius annum tricensimum terminabat, insolentiae pondera gravius librans, siquid dubium deferebatur aut falsum, Gerontium Magnentianae comitem partis exulari maerore multavit.\n" +
                "\n",R.drawable.rest_img_2,
                "fb.com/CellardelRoca",
                "023958230",
                "CellardelRoca@gmail.com",
                "Twitter/@CellardelRoca",
                "Adresse Resto 2"
        ));
        lstResto.add(new Resto("Mirazur","Categorie Book","Haec igitur Epicuri non probo, inquam. De cetero vellem equidem aut ipse doctrinis fuisset instructior est enim, quod tibi ita videri necesse est, non satis politus iis artibus, quas qui tenent, eruditi appellantur aut ne deterruisset alios a studiis. quamquam te quidem video minime esse deterritum.\n" +
                "\n",R.drawable.rest_img_3,
                "fb.com/Mirazur",
                "021772850",
                "Mirazur@gmail.com",
                "Twitter/@Mirazur",
                "Adresse Resto 3"
        ));
        lstResto.add(new Resto("Narisawa","Categorie Book","Ergo ego senator inimicus, si ita vultis, homini, amicus esse, sicut semper fui, rei publicae debeo. Quid? si ipsas inimicitias, depono rei publicae causa, quis me tandem iure reprehendet, praesertim cum ego omnium meorum consiliorum atque factorum exempla semper ex summorum hominum consiliis atque factis mihi censuerim petenda.\n" +
                "\n",R.drawable.rest_img_4,
                "fb.com/Narisawa",
                "023963306",
                "Narisawa@gmail.com",
                "Twitter/@Narisawa",
                "Adresse Resto 4"
        ));
        lstResto.add(new Resto("Steirereck","Categorie Book","Eminuit autem inter humilia supergressa iam impotentia fines mediocrium delictorum nefanda Clematii cuiusdam Alexandrini nobilis mors repentina; cuius socrus cum misceri sibi generum, flagrans eius amore, non impetraret, ut ferebatur, per palatii pseudothyrum introducta, oblato pretioso reginae monili id adsecuta est,permissus occideretur.\n" +
                "\n",R.drawable.rest_img_5,
                "fb.com/Steirereck",
                "021152637",
                "Steirereck@gmail.com",
                "Twitter/@Steirereck",
                "Adresse Resto 5"
        ));
        lstResto.add(new Resto("Asador Etxebarri","Categorie Book","Hoc inmaturo interitu ipse quoque sui pertaesus excessit e vita aetatis nono anno atque vicensimo cum quadriennio imperasset. natus apud Tuscos in Massa Veternensi, patre Constantio Constantini fratre imperatoris, matreque Galla sorore Rufini et Cerealis, quos trabeae consulares nobilitarunt et praefecturae.\n" +
                "\n",R.drawable.rest_img_6,
                "fb.com/AsadorEtxebarri",
                "023446722",
                "AsadorEtxebarri@gmail.com",
                "Twitter/@AsadorEtxebarri",
                "Adresse Resto 6"
        ));
        lstResto.add(new Resto("Azurmendi","Categorie Book","Ultima Syriarum est Palaestina per intervalla magna protenta, cultis abundans terris et nitidis et civitates habens quasdam egregias, nullam nulli cedentem sed sibi vicissim velut ad perpendiculum aemulas: Caesaream, quam ad honorem Octaviani principis exaedificavit Herodes, et Eleutheropolim et Neapolim itidemque Ascalonem Gazam aevo superiore exstructas.\n" +
                "\n",R.drawable.rest_img_7,
                "fb.com/Azurmendi",
                "021993568",
                "Azurmendi@gmail.com",
                "Twitter/@Azurmendi",
                "Adresse Resto 7"
        ));
        lstResto.add(new Resto("White Rabbit","Categorie Book","Eodem tempore etiam Hymetii praeclarae indolis viri negotium est actitatum, cuius hunc novimus esse textum. cum Africam pro consule regeret Carthaginiensibus victus inopia iam lassatis, ex horreis Romano populo destinatis frumentum dedit, pauloque postea cum provenisset segetum copia, integre sine ulla restituit mora.\n" +
                "\n",R.drawable.rest_img_8,
                "fb.com/WhiteRabbit",
                "023938523",
                "WhiteRabbit@gmail.com",
                "Twitter/@WhiteRabbit",
                "Adresse Resto 8"
        ));
        lstResto.add(new Resto("Piazza Duomo","Categorie Book","Omitto iuris dictionem in libera civitate contra leges senatusque consulta; caedes relinquo; libidines praetereo, quarum acerbissimum extat indicium et ad insignem memoriam turpitudinis et paene ad iustum odium imperii nostri, quod constat nobilissimas virgines se in puteos abiecisse et morte voluntaria necessariam turpitudinem depulisse. Nec haec idcirco omitto, quod non gravissima sint, sed quia nunc sine teste dico.\n" +
                "\n",R.drawable.rest_img_9,
                "fb.com/PiazzaDuomo",
                "021234512",
                "PiazzaDuomo@gmail.com",
                "Twitter/@PiazzaDuomo",
                "Adresse Resto 9"
        ));
        lstResto.add(new Resto("Clove Club","Categorie Book","Et prima post Osdroenam quam, ut dictum est, ab hac descriptione discrevimus, Commagena, nunc Euphratensis, clementer adsurgit, Hierapoli, vetere Nino et Samosata civitatibus amplis inlustris.\n" +
                "\n",R.drawable.rest_img_10,
                "fb.com/TheCloveClub",
                "021993568",
                "TheCloveClub@gmail.com",
                "Twitter/@TheCloveClub",
                "Adresse Resto 10"
        ));
        lstResto.add(new Resto("Astrid Gaston","Categorie Book","Sed tamen haec cum ita tutius observentur, quidam vigore artuum inminuto rogati ad nuptias ubi aurum dextris manibus cavatis offertur, inpigre vel usque Spoletium pergunt. haec nobilium sunt instituta.\n" +
                "\n",R.drawable.rest_img_1,
                "fb.com/AstridYGaston",
                "021459628",
                "AstridYGaston@gmail.com",
                "Twitter/@AstridYGaston",
                "Adresse Resto 11"
        ));
        lstResto.add(new Resto("La Calandre","Categorie Book","Quanta autem vis amicitiae sit, ex hoc intellegi maxime potest, quod ex infinita societate generis humani, quam conciliavit ipsa natura, ita contracta res est et adducta in angustum ut omnis caritas aut inter duos aut inter paucos iungeretur.\n" +
                "\n",R.drawable.rest_img_2,
                "fb.com/LaCalandre",
                "023958230",
                "LaCalandre@gmail.com",
                "Twitter/@LaCalandre",
                "Adresse Resto 12"
        ));
        lstResto.add(new Resto("Septime","Categorie Book","Proinde concepta rabie saeviore, quam desperatio incendebat et fames, amplificatis viribus ardore incohibili in excidium urbium matris Seleuciae efferebantur, quam comes tuebatur Castricius tresque legiones bellicis sudoribus induratae.\n" +
                "\n",R.drawable.rest_img_3,
                "fb.com/Septime",
                "023963306",
                "Septime@gmail.com",
                "Twitter/@Septime",
                "Adresse Resto 13"
        ));
        lstResto.add(new Resto("Quique Dacosta","Categorie Book","Sed tamen haec cum ita tutius observentur, quidam vigore artuum inminuto rogati ad nuptias ubi aurum dextris manibus cavatis offertur, inpigre vel usque Spoletium pergunt. haec nobilium sunt instituta.\n" +
                "\n",R.drawable.rest_img_4,
                "fb.com/QuiqueDacosta",
                "021152637",
                "QuiqueDacosta@gmail.com",
                "Twitter/@QuiqueDacosta",
                "Adresse Resto 14"
        ));
        lstResto.add(new Resto("Attica","Categorie Book","Post quorum necem nihilo lenius ferociens Gallus ut leo cadaveribus pastus multa huius modi scrutabatur. quae singula narrare non refert, me professione modum, quod evitandum est, excedamus.\n" +
                "\n",R.drawable.rest_img_5,
                "fb.com/Attica",
                "021993568",
                "Attica@gmail.com",
                "Twitter/@Attica",
                "Adresse Resto 15"
        ));





        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstResto);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.menu);

        return true;
    }

}
