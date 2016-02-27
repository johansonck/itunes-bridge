-- This script requires 3 arguments:
-- 1. the name of the song
-- 2. the name of the album
-- 3. the name of the artist

on run argv
	tell application "iTunes"
		set allInfo to {}

		tell (some file track whose name is item 1 of argv and album is item 2 of argv and artist is item 3 of argv)
			set end of allInfo to get persistent ID
			set end of allInfo to get name
			set end of allInfo to get album
			set end of allInfo to get artist
			set end of allInfo to get track number
			set end of allInfo to get disc number
			set end of allInfo to get rating
			set end of allInfo to get album rating
			set end of allInfo to get album rating kind as text
			set end of allInfo to get location as text
			set end of allInfo to get rating kind as text
			set end of allInfo to get played date
		end tell

		return allInfo
	end tell
end run