package com.adidyk.start;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.io.IOException;
import java.util.Date;

public class ParserSqlRuJob implements Job {

    /**
     *
     */
    private ParserDate parserDate = new ParserDate();

    /**
     * @param parserSqlRu - parser sql ru.
     */
    private ParserSqlRu parserSqlRu = new ParserSqlRu(this.parserDate);


    /**
     *
     */
    private String url = "http://www.sql.ru/forum/job-offers/";


    /**
     *
     * @param parserSqlRu - is.
     * @param parserDate - is.
     */
    void initialization(ParserSqlRu parserSqlRu, ParserDate parserDate) {
        this.parserSqlRu = parserSqlRu;
        this.parserDate = parserDate;

    }

    /**
     *
     * @return - is.
     * @throws IOException - is.
     */
    int checkFirstStart() throws IOException {
        int page = 1;
        if (this.parserSqlRu.checkTableIsEmpty()) {
            System.out.println(this.parserSqlRu.checkTableIsEmpty());
            page = parserSqlRu.searchPageByDate(this.parserDate.parse("31 дек 17, 13:28"));
            System.out.println("number: " + page);
        }
        return page;
    }

    /**
     *
     * @param page - is page.
     * @throws IOException - exception.
     */
    void parserAllPage(int page) throws IOException {
        for (int index = 10; index <= page; index++) {
        this.parserSqlRu.parse(url + index);
        System.out.println("page: " + url + index);
        this.parserSqlRu.addVacancy();
        }
    }

    /**
     *
     */
    private void test() throws IOException {
        System.out.println("[test] run ....");

       Date date = this.parserSqlRu.getLastDate();
       System.out.println("[date]: " + this.parserDate.formatDate(date));
       int page = this.parserSqlRu.searchPageByDate(date);
        System.out.println("[page]: " + page);
       for (int index = 1; index <= page; index++) {
           this.parserSqlRu.parse(url + index);
           System.out.println("page: " + url + index);
           this.parserSqlRu.addVacancy();
       }
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello word");
        System.out.println(new Date());
        try {
            this.test();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
        //1 Select last date from data base.
        //2 Search page in sql.ru by last date vacancy.
        //3 purser now

}