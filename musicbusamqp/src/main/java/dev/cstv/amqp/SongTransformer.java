package dev.cstv.amqp;

import dev.cstv.musify.domain.Song;

public interface SongTransformer {

	Song transform (Song item);
}
