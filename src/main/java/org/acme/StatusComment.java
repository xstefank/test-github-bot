package org.acme;

import io.quarkiverse.githubapp.event.Status;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHEventPayload;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.PagedIterable;

import java.io.IOException;

public class StatusComment {

    void onStatusUpdate(@Status GHEventPayload.Status statusPayload) throws IOException {
        GHCommit commit = statusPayload.getCommit();
        System.out.println(commit.getSHA1());

        PagedIterable<GHPullRequest> ghPullRequests = commit.listPullRequests();
        System.out.println(ghPullRequests.toList().size());
        ghPullRequests.forEach(System.out::println);

    }
}
