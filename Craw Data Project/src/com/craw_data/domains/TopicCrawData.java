package com.craw_data.domains;

import com.craw_data.domains.base.BaseCrawData;
import com.craw_data.models.Topic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TopicCrawData extends BaseCrawData<Topic> {
    @Override
    public int loadFromDisk(List<String> paths) {
        return 0;
    }

    @Override
    public int loadFromDisk(String path) {
        try (Scanner s = new Scanner(new FileReader(path))) {
            while (s.hasNext()) {
                String line = s.nextLine();
                // Convert raw data to Topic object
                if (line.startsWith("+")) {
                    Topic newTopic = new Topic();
                    newTopic.setTitle(line.substring(2));
                    items.add(newTopic);
                } else if (!line.isEmpty()) {
                    Topic.nextCategoryId++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items.size();
    }
}
