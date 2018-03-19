package ru.aleksandrorlov.data.net;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 17.03.18.
 */

public class FakeDataNet {
    private final String TAG = this.getClass().getSimpleName();

    private static final YandexPictureEntity[] FAKE_DATA = {
            new YandexPictureEntity("http://knigi.prof-press.ru/pub/files/infuso_eshop_model_itemphoto/00/12557/90dec041_c686_11e1_81d3_5ef3fc502493_.jpeg", "деревья"),
            new YandexPictureEntity("https://7kun.kz/wp-content/uploads/2015/09/1404831601023.jpg", "деревья"),
            new YandexPictureEntity("https://www.sunhome.ru/i/wallpapers/119/osennee-derevo.960x540.jpg", "деревья"),
            new YandexPictureEntity("http://oboi-korea.ru/upload/iblock/660/51249.jpg", "деревья"),
            new YandexPictureEntity("http://classpic.ru/wp-content/uploads/Neveroyatno-krasivoe-derevo.jpg", "деревья"),
            new YandexPictureEntity("http://namonitore.ru/uploads/catalog/leto/raskidistoe_zelenoe_derevo_1280.jpg", "деревья"),
            new YandexPictureEntity("http://gooodnews.ru/images/trees/trees15.jpg", "деревья"),
            new YandexPictureEntity("https://grandgames.net/puzzle/full/derevya_1.jpg", "деревья"),
            new YandexPictureEntity("https://fullhdpictures.com/wp-content/uploads/2015/04/Amazing-Trees-Wallpapers.jpg", "деревья"),
            new YandexPictureEntity("http://st.gdefon.com/wallpapers_original/s/100886_osen_derevya_opadayushhie_listya_dorozhka_3872x2572_(www.GdeFon.ru).jpg", "деревья"),
            new YandexPictureEntity("https://s1.1zoom.ru/big7/220/Grasslands_Camomiles_419661.jpg", "лето"),
            new YandexPictureEntity("http://zoozel.ru/gallery/images/617668_nadpis-leto-v-kartinkah.jpg", "лето"),
            new YandexPictureEntity("http://s4.thingpic.com/images/nS/rbNoaxqRCwMHg6dWAtdcj6DD.jpeg", "лето"),
            new YandexPictureEntity("https://get.wallhere.com/photo/sunlight-landscape-mountains-flowers-nature-sky-field-clouds-summer-valley-wilderness-Alps-plateau-autumn-mountain-flower-grassland-plant-pasture-meadow-plain-wildflower-prairie-rural-area-natural-environment-land-plant-flowering-plant-mountainous-landforms-geographical-feature-ecosystem-mountain-range-215983.jpg", "лето"),
            new YandexPictureEntity("https://s1.1zoom.ru/big7/832/Scenery_Tropics_Sea_377431.jpg", "лето"),
            new YandexPictureEntity("http://www.kartinkijane.ru/pic/201304/1280x1024/kartinkijane.ru-1963.jpg", "лето"),
            new YandexPictureEntity("http://www.bhmpics.com/wallpapers/summer_field_flowers-1920x1080.jpg", "лето"),
            new YandexPictureEntity("https://www.nastol.com.ua/pic/201407/960x800/nastol.com.ua-105119.jpg", "лето"),
            new YandexPictureEntity("http://findmorecustomers.co.uk/wp-content/uploads/2012/02/Summer-Holidays12801024.jpg", "лето"),
            new YandexPictureEntity("http://wallpaperscraft.ru/image/maki_romashki_pole_nebo_razmytost_leto_41152_1920x1180.jpg", "лето"),
            new YandexPictureEntity("http://3.bp.blogspot.com/-pVNWP93ormA/VEX7xv4jqVI/AAAAAAAABhU/aoeoGWzDeOw/s1600/IMG_0802.jpg", "солнце"),
            new YandexPictureEntity("http://www.2fons.ru/pic/201407/1920x1200/2fons.ru-47276.jpg", "солнце"),
            new YandexPictureEntity("http://www.2fons.ru/pic/201407/1920x1200/2fons.ru-46890.jpg", "солнце"),
            new YandexPictureEntity("http://123hdwallpaperpic.com/download/20150513/golden-sun-wallpaper-1920x1080.jpg", "солнце"),
            new YandexPictureEntity("http://images.easyfreeclipart.com/21/yellow-sun-clipart-glossy-icon-download-21623.jpg", "солнце"),
            new YandexPictureEntity("https://www.look.com.ua/large/201312/85447.jpg", "солнце"),
            new YandexPictureEntity("http://www.stihi.ru/pics/2017/03/27/11816.jpg", "солнце"),
            new YandexPictureEntity("http://www.stihi.ru/pics/2012/03/21/10255.jpg", "солнце"),
            new YandexPictureEntity("https://get.wallhere.com/photo/sunlight-landscape-mountains-sunset-flowers-hill-nature-sky-sunrise-morning-wilderness-dusk-plateau-cloud-autumn-mountain-flower-dawn-grassland-meadow-wildflower-prairie-natural-environment-mountainous-landforms-geographical-feature-ecosystem-mountain-range-207824.jpg", "солнце"),
            new YandexPictureEntity("http://1.bp.blogspot.com/-N5KS4NBV_58/U9wSR0rxnCI/AAAAAAAAPLY/zASqo5WXXHo/s1600/sunrise.jpg", "солнце"),
            new YandexPictureEntity("https://megatoys24.ru/uploads/all/f8/40/ea/f840ea4e4969f46ba35c523dc5192b72.jpg", "динозавр"),
            new YandexPictureEntity("http://gazetadaily.ru/wp-content/uploads/2017/02/Dinosaur.jpg", "динозавр"),
            new YandexPictureEntity("https://zhirafa-tut.ru/components/com_jshopping/files/img_products/full_img_full_img_full_14530.jpg", "динозавр"),
            new YandexPictureEntity("https://static.dochkisinochki.ru/upload/_catalog/e2/54/5d/GL000398800_001.jpg", "динозавр"),
            new YandexPictureEntity("http://www.v3toys.ru/kiwi-public-data/Kiwi_Img/579e43eb63da8.jpg", "динозавр"),
            new YandexPictureEntity("http://moskva.catalog2b.ru/uimages/product/014/090/885-full_img_full_img_full_14531.jpg", "динозавр"),
            new YandexPictureEntity("https://s1.1zoom.ru/big7/737/Ancient_animals_376324.jpg", "динозавр"),
            new YandexPictureEntity("https://topblognews.ru/wp-content/uploads/2016/12/dinos.jpg", "динозавр"),
            new YandexPictureEntity("http://www.v3toys.ru/kiwi-public-data/Kiwi_Img/57891c07efaee.jpg", "динозавр"),
            new YandexPictureEntity("https://i.ytimg.com/vi/zneiyfDQcTQ/maxresdefault.jpg", "динозавр"),

    };

    private String url;
    private String request;

    YandexPictureEntity getYandexPictureEntity() {
        Random random = new Random();
        return FAKE_DATA[random.nextInt(FAKE_DATA.length - 1)];
    }

    public List<YandexPictureEntity> getYandexPictureEntityList() {
        return new ArrayList<>(Arrays.asList(FAKE_DATA));
    }
}
