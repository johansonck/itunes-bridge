package be.sonck.itunes.api.model;

import com.google.common.collect.ImmutableSortedSet;

import java.util.SortedSet;

/**
 * Created by johansonck on 13/12/15.
 */
abstract class GenericFolderPlaylistBuilder<B extends GenericFolderPlaylistBuilder<B>> extends GenericItemBuilder<B> {

    SortedSet<Playlist> children;

    public B children(SortedSet<Playlist> children) {
        this.children = ImmutableSortedSet.copyOf(new PlaylistComparator(), children);
        return (B) this;
    }
}
