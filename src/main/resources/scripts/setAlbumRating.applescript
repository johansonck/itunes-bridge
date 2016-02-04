-- This script requires 3 arguments:
-- 1. the persitent id of the song
-- 2. the song rating
-- 3. the album rating

on run argv
  tell application "iTunes"
    set allInfo to {}

    tell (some track whose persistent ID is item 1 of argv)
      set album rating to item 2 of argv
    end tell
  end tell
end run