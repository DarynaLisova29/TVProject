package com.example.tvproject.com.example.tvproject

import android.annotation.SuppressLint
import android.text.SpannedString
import android.util.Log
import com.egeniq.androidtvprogramguide.ProgramGuideFragment
import com.egeniq.androidtvprogramguide.entity.ProgramGuideSchedule
import com.example.tvproject.EpgFragment
import com.example.tvproject.SimpleCity
import com.example.tvproject.SimpleProgram
import com.example.tvproject.WeatherCreate
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class MyEpgFragment2 : ProgramGuideFragment<SimpleProgram>() {
    companion object {
        private val TAG = MyEpgFragment2::class.java.name
    }
    override fun isTopMenuVisible(): Boolean {
        TODO("Not yet implemented")
    }

    override fun requestRefresh() {
        TODO("Not yet implemented")
    }

    @SuppressLint("CheckResult")
    override fun requestingProgramGuideFor(localDate: LocalDate) {
        // Faking an asynchronous loading here
        setState(State.Loading)
//        weatherCreate.getWeather(44.34,10.99);
        Single.fromCallable {
            val  cities = listOf(
                SimpleCity(
                    30.5234,
                    50.4501,
                    SpannedString("Kyiv"),
                    "https://24tv.ua/resources/photos/news/202302/2264415.jpg?v=1677577647000"
                ),
                SimpleCity(
                    24.0297,
                    49.8397,
                    SpannedString("Lviv"),
                    "https://we.org.ua/wp-content/uploads/2014/12/vulytsi-nichnogo-lvova.jpeg"
                ),
                SimpleCity(
                    36.2304,
                    49.9935,
                    SpannedString("Kharkiv"),
                    "https://tamtour.com.ua/local/image/585/009/gor13.jpg"
                ),
                SimpleCity(
                    30.7233,
                    46.4825,
                    SpannedString("Odesa"),
                    "https://th.bing.com/th/id/R.7ff279895725dcf4929483e9dc4aca4c?rik=5UkJg9mv3CGyDw&pid=ImgRaw&r=0"
                ),
                SimpleCity(
                    35.0462,
                    48.4647,
                    SpannedString("Dnipro"),
                    "https://ua.igotoworld.com/frontend/webcontent/websites/1/images/gallery/7526_800x600_Dnepropetrovsk.jpg"
                ),
                SimpleCity(
                    35.1396,
                    47.8388,
                    SpannedString("Zaporizhzhia"),
                    "https://th.bing.com/th/id/R.c6e7d16b59731109229b6c2ca2b4df53?rik=f9uVggbB7jvDqw&pid=ImgRaw&r=0"
                ),
                SimpleCity(
                    37.8029,
                    48.0159,
                    SpannedString("Donetsk"),
                    "https://th.bing.com/th/id/R.3f65724ccb0bc74ad0fdab44953bb52b?rik=qAybpusUubqHUQ&riu=http%3a%2f%2fargumentua.com%2fi%2fdonetsk_01.jpg&ehk=AMar9T6HH8%2byimYbI420NQEDcM1QK1JQnB3hx3PJXoQ%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1"
                ),
                SimpleCity(
                    25.9358,
                    48.2915,
                    SpannedString("Chernivtsi"),
                    "https://th.bing.com/th/id/OIP.CBj-q2KJTJWrVENLFJbTBAHaFo?w=214&h=180&c=7&r=0&o=5&pid=1.7"
                ),
                SimpleCity(
                    24.7111,
                    48.9226,
                    SpannedString("Ivano-Frankivsk"),
                    "https://karpaty.life/uploads/ivano-frankivsk/ivano-frankivsk-stometrivka.jpg"
                ),
                SimpleCity(
                    28.4800,
                    49.2328,
                    SpannedString("Vinnytsia"),
                    "https://th.bing.com/th/id/OIP.6Fmyp1MKzOS4XEzkJUFWEgHaE6?rs=1&pid=ImgDetMain"
                )
            )
            val weatherData= WeatherCreate.getWeatherList(cities);
            weatherData.forEach { weatherData ->
                Log.d("City Result", weatherData.toString());
            }
            Log.d("Size ",cities.size.toString());
            Log.d("Size ",weatherData.size.toString());



            val channelMap = mutableMapOf<String, List<ProgramGuideSchedule<SimpleProgram>>>()
            for(i in 0 until weatherData.size){
                val scheduleList = mutableListOf<ProgramGuideSchedule<SimpleProgram>>();
                for(j in 0 until 8){
                    var nextTime=weatherData.get(i).list[j].time;
                    var endTime=weatherData.get(i).list[j+1].time;
                    val schedule=createSchedule(weatherData[i].list[j].weather[0].main,nextTime, endTime)
                    scheduleList.add(schedule);
                }
                channelMap[cities[i].id]=scheduleList;
            }
            return@fromCallable Pair(cities, channelMap)
        }.delay(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                setData(it.first, it.second, localDate)
                if (it.first.isEmpty() || it.second.isEmpty()) {
                    setState(State.Error("No channels loaded."))
                } else {
                    setState(State.Content)
                }
            }, {
                Log.e(TAG, "Unable to load example data!", it)
            })
    }

    override fun onScheduleSelected(programGuideSchedule: ProgramGuideSchedule<SimpleProgram>?) {
        TODO("Not yet implemented")
    }

    override fun onScheduleClicked(programGuideSchedule: ProgramGuideSchedule<SimpleProgram>) {
        TODO("Not yet implemented")
    }

    private fun createSchedule(
        scheduleName: String,
        startTime: ZonedDateTime,
        endTime: ZonedDateTime
    ): ProgramGuideSchedule<SimpleProgram> {
        val id = Random.nextLong(100_000L)
        val metadata = DateTimeFormatter.ofPattern("'Starts at' HH:mm").format(startTime)
        return ProgramGuideSchedule.createScheduleWithProgram(
            id,
            startTime.toInstant(),
            endTime.toInstant(),
            true,
            scheduleName,
            SimpleProgram(
                id.toString(),
                "This is an example description for the programme. This description is taken from the SimpleProgram class, so by using a different class, " +
                        "you could easily modify the demo to use your own class",
                metadata
            )
        )
    }
}