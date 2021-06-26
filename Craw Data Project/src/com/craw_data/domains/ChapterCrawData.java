package com.craw_data.domains;

import com.craw_data.domains.base.BaseCrawData;
import com.craw_data.models.Chapter;

import java.util.List;

public class ChapterCrawData extends BaseCrawData<Chapter> {
    @Override
    public int loadFromDisk(List<String> paths) {
        return 0;
    }

    @Override
    public int loadFromDisk(String path) {
        return 0;
    }
}
