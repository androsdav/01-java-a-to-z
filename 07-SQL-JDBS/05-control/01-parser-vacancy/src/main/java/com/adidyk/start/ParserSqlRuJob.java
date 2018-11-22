package com.adidyk.start;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.Date;

public class ParserSqlRuJob implements Job {

    /**
     * @param parserSqlRu - parser sql ru.
     */
    private ParserSqlRu parserSqlRu;

    /**
     *
     */
    private ParserDate parserDate;

    /**
     *
     */
    private String url = "http://www.sql.ru/forum/job-offers/";

    /**
     *
     * @param parserSqlRu - link variable to object of class ParserSqlRu.
     */
    ParserSqlRuJob(ParserSqlRu parserSqlRu, ParserDate parserDate) {
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
    void parser(int page) throws IOException {
        for (int index = 1; index <= page; index++) {
        this.parserSqlRu.parse(url + index);
        System.out.println("page: " + url + index);
        this.parserSqlRu.addVacancy();
        }
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {


    }
        //1 Select last date from data base.
        //2 Search page in sql.ru by last date vacancy.
        //3 purser now
    }

}
