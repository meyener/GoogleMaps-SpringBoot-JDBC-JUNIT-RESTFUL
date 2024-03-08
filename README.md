## SpringBoot-GoogleMaps



* This project provides to find and save restaurant which one in given radius
* SpringBoot
* JDBC
* JUNIT
* H2 Database
* Soft Delete
* Swagger UI

##### Open Google Maps and right click any point in map and copy that put in URL

template query URL : https://maps.googleapis.com/maps/api/place/nearbysearch/json?location={EnterLocaiton}&radius={Radıus}&key={YourApiKey}

Instance query URL : https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=37.06335034258971,%2037.363809476518675&radius=60&key={YourApiKey}



##### Types at  the bottom defines kind of place


* Request Body
```json
{
"latitude": 37.06383227363729,
"longitude": 37.363071671503455,
"radius": 100
}

* Response Body(getAll)

[
{
"id": 1,
"lat": 37.0640294,
"lng": 37.363308,
"restaurantId": "ChIJzzrS_z7hMRURkKw9iSMsOJY",
"name": "Dürümx",
"types": "[\"restaurant\",\"food\",\"point_of_interest\",\"establishment\"]",
"vicinity": "Değirmiçem, Fevzi Çakmak Bulvarı No:24",
"deleted": false
},
{
"id": 2,
"lat": 37.063427,
"lng": 37.362581,
"restaurantId": "ChIJIzkjMBThMRURWejME2zqOU8",
"name": "McDonald's",
"types": "[\"restaurant\",\"food\",\"point_of_interest\",\"establishment\"]",
"vicinity": "Sarıgüllük, Sarıgüllük Mahallesi Mareşal, Fevzi Çakmak Bulvarı No:379",
"deleted": false
},
{
"id": 3,
"lat": 37.063516,
"lng": 37.3628006,
"restaurantId": "ChIJc-w4uD_hMRURp8aF-Stqav8",
"name": "Hızlı Ve Köfteli Gaziantep",
"types": "[\"restaurant\",\"food\",\"point_of_interest\",\"establishment\"]",
"vicinity": "Sarıgüllük",
"deleted": false
},
{
"id": 4,
"lat": 37.0635051,
"lng": 37.3627851,
"restaurantId": "ChIJ6RiOuD_hMRURVIBrmuAEXzc",
"name": "Cevizli Kofteci",
"types": "[\"restaurant\",\"food\",\"point_of_interest\",\"establishment\"]",
"vicinity": "Emek, İsmet Rafet İşitmen Cad. Sanko Park Alışveriş Merkezi No:223",
"deleted": false
}
]


instance JSON complete response,we have to pick right one checck types whick restaurant

{
   "html_attributions" : [],
   "results" : 
   [
      {
         "geometry" : 
         {
            "location" : 
            {
               "lat" : 37.06188000003591,
               "lng" : 37.36192050040846
            },
            "viewport" : 
            {
               "northeast" : 
               {
                  "lat" : 37.06322898029149,
                  "lng" : 37.36326948029149
               },
               "southwest" : 
               {
                  "lat" : 37.0605310197085,
                  "lng" : 37.3605715197085
               }
            }
         },
         "icon" : "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/geocode-71.png",
         "icon_background_color" : "#7B9EB0",
         "icon_mask_base_uri" : "https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet",
         "name" : "Bestekar Mehmet Sokak",
         "place_id" : "ChIJaWy0GT7hMRURxAF1hEYr96I",
         "reference" : "ChIJaWy0GT7hMRURxAF1hEYr96I",
         "scope" : "GOOGLE",
         "types" : 
         [
            "route"
         ]
      },
      {
         "business_status" : "OPERATIONAL",
         "geometry" : 
         {
            "location" : 
            {
               "lat" : 37.06204599999999,
               "lng" : 37.362104
            },
            "viewport" : 
            {
               "northeast" : 
               {
                  "lat" : 37.06348508029149,
                  "lng" : 37.3634469802915
               },
               "southwest" : 
               {
                  "lat" : 37.06078711970849,
                  "lng" : 37.3607490197085
               }
            }
         },
         "icon" : "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png",
         "icon_background_color" : "#7B9EB0",
         "icon_mask_base_uri" : "https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet",
         "name" : "Baştuğ Yapı Mühendislik",
         "opening_hours" : 
         {
            "open_now" : true
         },
         "photos" : 
         [
            {
               "height" : 1066,
               "html_attributions" : 
               [
                  "\u003ca href=\"https://maps.google.com/maps/contrib/101695483951744179439\"\u003eHasar Uzmanı\u003c/a\u003e"
               ],
               "photo_reference" : "ATplDJYhglcXw1y_jDOYkSguSGop6nw_DTrVzNQdwoVM5MY0xt60f2NmRcwxQR7Q-X8m9CXvmJR9jUkx9dtwEossK6X82gVqr_V97QqCjvEojVocS7_7CGxgVtkT6ySWZxKy1_XDG4GadGgLFyt2fGOz1SCoDyMEfQMUkryrLFEesu9AxzWO",
               "width" : 1600
            }
         ],
         "place_id" : "ChIJ0wVWRdXhMRURR6kONVny5Qs",
         "plus_code" : 
         {
            "compound_code" : "3966+RR Şahinbey/Gaziantep, Türkiye",
            "global_code" : "8G9V3966+RR"
         },
         "rating" : 5,
         "reference" : "ChIJ0wVWRdXhMRURR6kONVny5Qs",
         "scope" : "GOOGLE",
         "types" : 
         [
            "general_contractor",
            "point_of_interest",
            "establishment"
         ],
         "user_ratings_total" : 1,
         "vicinity" : "Kavaklık, Ahmet Apaydın Caddesi NO:17/A"
      },
      {
         "business_status" : "OPERATIONAL",
         "geometry" : 
         {
            "location" : 
            {
               "lat" : 37.06204599999999,
               "lng" : 37.362104
            },
            "viewport" : 
            {
               "northeast" : 
               {
                  "lat" : 37.06348508029149,
                  "lng" : 37.3634469802915
               },
               "southwest" : 
               {
                  "lat" : 37.06078711970849,
                  "lng" : 37.3607490197085
               }
            }
         },
         "icon" : "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png",
         "icon_background_color" : "#7B9EB0",
         "icon_mask_base_uri" : "https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet",
         "name" : "Stüdyo Serap",
         "opening_hours" : 
         {
            "open_now" : true
         },
         "photos" : 
         [
            {
               "height" : 1365,
               "html_attributions" : 
               [
                  "\u003ca href=\"https://maps.google.com/maps/contrib/116020298162810659895\"\u003egökhan Sırtlan\u003c/a\u003e"
               ],
               "photo_reference" : "ATplDJbU13zb_L_4geJQrAIsXivYGncBleTxdKHK7os4etHQmIZuRmAC5GIGIGnKd7-rKs1BJGW5-8R_C8wgiL1zy6k9jxT_EmWQl8J5WyXMwaCtQQ8Q8jA68TAtxJd0QXKqHSYBs1_yK029tdEWPIrA0HYhp1NvprNyzypnnM3be0CFoLoD",
               "width" : 2048
            }
         ],
         "place_id" : "ChIJd73MZqzmMRUR-RyggLw1evE",
         "plus_code" : 
         {
            "compound_code" : "3966+RR Şahinbey/Gaziantep, Türkiye",
            "global_code" : "8G9V3966+RR"
         },
         "rating" : 3.8,
         "reference" : "ChIJd73MZqzmMRUR-RyggLw1evE",
         "scope" : "GOOGLE",
         "types" : 
         [
            "point_of_interest",
            "establishment"
         ],
         "user_ratings_total" : 69,
         "vicinity" : "Kavaklık, Ahmet Apaydın Caddesi 17/A"
      },
      {
         "business_status" : "OPERATIONAL",
         "geometry" : 
         {
            "location" : 
            {
               "lat" : 37.062105,
               "lng" : 37.362013
            },
            "viewport" : 
            {
               "northeast" : 
               {
                  "lat" : 37.0635127302915,
                  "lng" : 37.3633580302915
               },
               "southwest" : 
               {
                  "lat" : 37.0608147697085,
                  "lng" : 37.3606600697085
               }
            }
         },
         "icon" : "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png",
         "icon_background_color" : "#FF9E67",
         "icon_mask_base_uri" : "https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet",
         "name" : "Feyzi Dondurma Kavaklık",
         "opening_hours" : 
         {
            "open_now" : true
         },
         "photos" : 
         [
            {
               "height" : 1536,
               "html_attributions" : 
               [
                  "\u003ca href=\"https://maps.google.com/maps/contrib/104537128001149651850\"\u003eFeyzi Dondurma Kavaklık\u003c/a\u003e"
               ],
               "photo_reference" : "ATplDJYLT5nrpbqNCm85pbAvrxZ-IpkrgRurlVM4CLAkYiNNEVBIS0jY-I4Hg2SJniw2M1VuFc7VSZkhnpGsm8XwD973xLmMBzJx0ySxls04setXsLDFFdgttRCocam0nb9fdB2s80c60FNR_KPU79DszaHevreplXqWBWjsn0kojEHBP9cq",
               "width" : 2048
            }
         ],
         "place_id" : "ChIJY8Luo7rhMRUR6tYkAj0MV1Y",
         "plus_code" : 
         {
            "compound_code" : "3966+RR Şahinbey/Gaziantep, Türkiye",
            "global_code" : "8G9V3966+RR"
         },
         "rating" : 4.2,
         "reference" : "ChIJY8Luo7rhMRUR6tYkAj0MV1Y",
         "scope" : "GOOGLE",
         "types" : 
         [
            "store",
            "food",
            "point_of_interest",
            "establishment"
         ],
         "user_ratings_total" : 51,
         "vicinity" : "Kavaklık, Ahmet Apaydın Caddesi no:17/B"
      },
      {
         "business_status" : "OPERATIONAL",
         "geometry" : 
         {
            "location" : 
            {
               "lat" : 37.0617154,
               "lng" : 37.3618026
            },
            "viewport" : 
            {
               "northeast" : 
               {
                  "lat" : 37.06307808029149,
                  "lng" : 37.3632294802915
               },
               "southwest" : 
               {
                  "lat" : 37.0603801197085,
                  "lng" : 37.3605315197085
               }
            }
         },
         "icon" : "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png",
         "icon_background_color" : "#7B9EB0",
         "icon_mask_base_uri" : "https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet",
         "name" : "Çağdaş Apartmanı",
         "place_id" : "ChIJ397eea_hMRURO8-G43MODGw",
         "plus_code" : 
         {
            "compound_code" : "3966+MP Şahinbey/Gaziantep, Türkiye",
            "global_code" : "8G9V3966+MP"
         },
         "reference" : "ChIJ397eea_hMRURO8-G43MODGw",
         "scope" : "GOOGLE",
         "types" : 
         [
            "point_of_interest",
            "establishment"
         ],
         "vicinity" : "Kavaklık, Bestekar Mehmet Sokak No:7"
      },
      {
         "geometry" : 
         {
            "location" : 
            {
               "lat" : 37.065953,
               "lng" : 37.37811
            },
            "viewport" : 
            {
               "northeast" : 
               {
                  "lat" : 37.10829097654749,
                  "lng" : 37.45677492278354
               },
               "southwest" : 
               {
                  "lat" : 37.00925187947443,
                  "lng" : 37.30349900540821
               }
            }
         },
         "icon" : "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/geocode-71.png",
         "icon_background_color" : "#7B9EB0",
         "icon_mask_base_uri" : "https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet",
         "name" : "Gaziantep",
         "photos" : 
         [
            {
               "height" : 4000,
               "html_attributions" : 
               [
                  "\u003ca href=\"https://maps.google.com/maps/contrib/104554490980194591952\"\u003eSeyfeddin Demir\u003c/a\u003e"
               ],
               "photo_reference" : "ATplDJYh7a4Wemn1vTdd9c84jnSR6BVHjmCnR9z4mdqobtj42cnOxBrVUd_G9OpuxPBgsS8A4p0OOMG3JJ4wCe_YImjhpykx2E4SXwZXoLzRdB-o5VIEHCtAjTSHfOtn6G2tuWeWfYtEnglz820Vm0j4U6E2mg95xWL6TGpiAehcLaAy7p4V",
               "width" : 3000
            }
         ],
         "place_id" : "ChIJL4zx97TmMRUR0KprETWLLsA",
         "reference" : "ChIJL4zx97TmMRUR0KprETWLLsA",
         "scope" : "GOOGLE",
         "types" : 
         [
            "locality",
            "political"
         ],
         "vicinity" : "Gaziantep"
      }
   ],
   "status" : "OK"
}
