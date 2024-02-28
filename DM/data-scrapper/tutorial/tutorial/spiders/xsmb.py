from pathlib import Path
import scrapy

class QuotesSpider(scrapy.Spider):
    name = "xsmb"

    def start_requests(self):
        urls = [
            "https://xoso.com.vn/xo-so-mien-bac/xsmb-p1.html"
        ]

        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        filename = f"xsmb.txt"
        # Path(filename).write_text(response.css(".table-result").get())

        special = response.css(".special-prize::text").get()
        prize1 = response.css(".prize1::text").get()
        
        string = f"""Special prize: {special} \n1st prize: {prize1}\n
        """

        with open(filename, "w", encoding="utf-8") as f:
            f.write(string)
        self.log(f"Saved file {filename}")
