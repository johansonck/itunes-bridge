on run argv
	tell application "iTunes"
		tell (some playlist whose persistent ID is item 1 of argv)
			set allTracks to {}
			
			repeat with i from item 2 of argv to item 3 of argv
				set currentTrack to file track i
				tell currentTrack
					set end of allTracks to get persistent ID & tab & name & tab & album & tab & artist & tab & track number & tab & disc number & tab & location
				end tell
			end repeat
			
			return allTracks
		end tell
	end tell
end run