import http.client
import json
import sys

conn = http.client.HTTPSConnection("covid-19-statistics.p.rapidapi.com")

headers = {
    'X-RapidAPI-Host': "covid-19-statistics.p.rapidapi.com",
    'X-RapidAPI-Key': "e7fc76a997mshcc80ea64c2bc66ap1e4485jsnf0a42fb184f3"
    }

#conn.request("GET", "/regions", headers=headers)                            # regions (OPTIONAL)
#conn.request("GET", "/provinces?iso=CHN", headers=headers)                  # province where is =country_code (iso is REQUIRED)
#conn.request("GET", "/reports/total?date=2020-04-07", headers=headers)      # world total reports in date (OPTIONAL)
#conn.request("GET", "/reports?city_name=Autauga&region_province=Alabama&iso=USA&region_name=US&q=US%20Alabama&date=2020-04-16", headers=headers)   # all fields are OPTIONAL (cities only work for USA)
# region_province                   iso                 region_name                     q                                                               date
# Alabama                           USA                 US                              US Alabama                                                      2020-04-16
# Filter by province name           Country ISO code    Filter by country/region name   The query string for search by country/region and province      The date of report in the format Y-m-d | default current date


# answer = conn.request("GET", "/reports?city_name=" + city_name + 
#                       "&region_province=" + province + 
#                       "&iso=" + iso + 
#                       "&region_name=" + region + 
#                       "&q=" + q[0] + "%20" + q[1] + 
#                       "&date=" date, headers=headers)

answer = conn.request("GET", "/reports?iso=PRT&date=2020-04-16", headers=headers)
res = conn.getresponse()
   
if res is not None:
    data = res.read()
    data = json.loads(data)
    print(data)
    print(data['data'][0]['confirmed'])